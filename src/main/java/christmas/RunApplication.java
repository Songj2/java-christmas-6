package christmas;

import christmas.controller.DateController;
import christmas.controller.EventController;
import christmas.domain.EventPrice;
import christmas.domain.MenuList;
import christmas.domain.Messages;
import christmas.domain.Order;
import christmas.util.Validate;
import christmas.viewer.InputViewer;
import christmas.viewer.OutputViewer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RunApplication {
    private InputViewer inputViewer = new InputViewer();
    private Validate validate = new Validate();
    private DateController dateController;
    private final EventController eventController = new EventController();
    private Set<Order> orderSet;
    private Set<String> orderMenuList;
    private int menuCount;

    public RunApplication() {
        int date = Integer.parseInt(inputDate());
        dateController = new DateController(date);
        int discountDate = dateController.getDiscountDate();
        System.out.println(discountDate);
        inputOrder();

        int totalBefore = eventController.calTotalPriceBeforeDiscount(orderSet);
        Map<String, Integer> benefitList = calBenefits(date, discountDate, totalBefore, orderSet);
        int benefitAmount = eventController.calTotalDiscount(benefitList);
        int discountAmount = discountAmount(benefitAmount, benefitList);
        new OutputViewer(date, orderSet, totalBefore, benefitAmount, discountAmount, benefitList);
    }

    private String inputDate() {
        String date;
        do {
            date = inputViewer.readDate();
        }
        while (!validate.validateDate(date));
        return date;
    }

    private void inputOrder() {
        boolean illegal;
        do {
            menuCount = 0;
            this.orderSet = new HashSet<>();
            orderMenuList = new HashSet<>();
            String orders = inputViewer.readOrder().trim();
            illegal = makeOrderSet(orders);
        } while (!validateOrder() || illegal);
    }

    private boolean makeOrderSet(String orders) {
        for (String order : orders.split(",")) {
            try {
                inputOrderCheck(order);
            } catch (IllegalArgumentException e) {
                System.out.println(Messages.ERROR_ORDER.getMessage());
                return true;
            }
        }
        return false;
    }

    private void inputOrderCheck(String order) {
        Order orderDTO = new Order(order);
        if (orderMenuList.contains(orderDTO.getMenu())) { //중복확인
            throw new IllegalArgumentException();
        }
        orderSet.add(orderDTO);
        orderMenuList.add(orderDTO.getMenu());
        menuCount += orderDTO.getCount();
    }

    private boolean validateOrder() {
        try {
            return validateOrderMenu(orderSet) && validateOrderCount();
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_ORDER.getMessage());
            return false;
        }
    }

    private boolean validateOrderMenu(Set<Order> orders) {
        MenuList menuList = new MenuList();
        for (Order order : orders) {
            if (menuList.getOrderableMenuList().containsKey(order.getMenu())) {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean validateOrderCount() {
        if (menuCount > 20) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private Map<String, Integer> calBenefits(int date, int discountDate, int totalBefore, Set<Order> orders) {
        Map<String, Integer> benefitList = new HashMap<>();
        if (totalBefore > 10000) {
            benefitList.put("크리스마스 디데이 할인", eventController.dDayEvent(discountDate));
            benefitList.put("요일 할인", eventController.weekEvent(date, orders));
            benefitList.put("특별 할인", eventController.specialDiscount(date));
            benefitList.put(("증정 이벤트"), eventController.presentationEvent(totalBefore));
        }
        return benefitList;
    }

    private int discountAmount(int price, Map<String, Integer> benefitList) {
        if (benefitList.containsKey("증정 이벤트")) {
            price -= EventPrice.PRESENTATION.getPrice();
        }
        return price;
    }
}
