package christmas;

import christmas.domain.EventPrice;
import christmas.domain.Menu;
import christmas.domain.MenuList;
import christmas.domain.Messages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RunApplication {
    private InputViewer inputViewer = new InputViewer();
    private Validate validate = new Validate();
    private DateController dateController;

    public RunApplication() {
        int date = Integer.parseInt(inputDate());
        dateController = new DateController(date);
        int discountDate = dateController.getDiscountDate();
        Set<Order> orders = inputOrder();

        EventController eventController = new EventController();
        int totalBefore = eventController.calTotalPriceBeforeDiscount(orders);
        Map<String, Integer> benefitList = new HashMap<>();
        if (totalBefore > 10000) {
            benefitList.put("크리스마스 디데이 할인", eventController.dDayEvent(discountDate));
            benefitList.put("요일 할인", eventController.weekEvent(date, orders) * EventPrice.DAY_DISCOUNT.getPrice());
            benefitList.put("특별 할인", eventController.specialDiscount(date));
            benefitList.put(("증정 이벤트"), eventController.presentationEvent(totalBefore));
        }
        int discountAmount= eventController.calTotalDiscount(benefitList);
        OutputViewer outputViewer = new OutputViewer();
        outputViewer.printMenu(orders);
        outputViewer.printPrice(totalBefore, Messages.OUTPUT_DISCOUNT_BEFORE.getMessage());
        outputViewer.printPresentation(benefitList);
        outputViewer.printBenefits(benefitList);

        outputViewer.printPrice(discountAmount, Messages.OUTPUT_BENEFITS_PRICE.getMessage());

        int paidMoney= discountAmount;
        if (benefitList.containsKey("증정 이벤트")){
            paidMoney-= EventPrice.PRESENTATION.getPrice();
        }
        outputViewer.printPrice(totalBefore - paidMoney, Messages.OUTPUT_DISCOUNT_AFTER.getMessage());


        outputViewer.printBadge(discountAmount);

    }

    private String inputDate() {
        String date;
        do {
            date = inputViewer.readDate();
        }
        while (!validate.validateDate(date));
        return date;
    }

    private Set<Order> inputOrder() {
        Set<Order> orderSet;
        Set<String> orderMenuList;
        MenuList menuList = new MenuList();
        do {
            String orders = inputViewer.readOrder();
            orderSet = new HashSet<>();
            orderMenuList = new HashSet<>();
            for (String order : orders.split(",")) {
                Order orderDTO = new Order(order);
                if (orderMenuList.contains(orderDTO.getMenu())) {
                    throw new IllegalArgumentException(Messages.ERROR_ORDER.getMessage() + "중복!");
                } else {
                    orderSet.add(orderDTO);
                    orderMenuList.add(orderDTO.getMenu());
                }
            }
        } while (!validateOrder(orderSet));
        return orderSet;
    }

    private boolean validateOrder(Set<Order> orders) {
        return validateOrderMenu(orders) && validateOrderCount(orders);
    }

    private boolean validateOrderMenu(Set<Order> orders) {
        MenuList menuList = new MenuList();
        for (Order order : orders) {
            if (menuList.getOrderableMenuList().containsKey(order.getMenu())) {
                return true;
            }
        }
        throw new IllegalArgumentException(Messages.ERROR_ORDER.getMessage() + "음료만");
//        return false;
    }

    private boolean validateOrderCount(Set<Order> orders) {
        int count = 0;
        for (Order order : orders) {
            count += order.getCount();
        }
        if (count > 20) {
            throw new IllegalArgumentException(Messages.ERROR_ORDER.getMessage() + "20개 이상");
//            return false;
        }
        return true;
    }
}
