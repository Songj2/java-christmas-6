package christmas;

import christmas.domain.MenuList;
import christmas.domain.Messages;

import java.util.HashSet;
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
        do {
            String orders = inputViewer.readOrder();
            orderSet = new HashSet<>();
            orderMenuList = new HashSet<>();
            for (String order : orders.split(",")) {
                Order orderDTO = new Order(order);
                if (orderMenuList.contains(orderDTO.getMenu())) {
                    throw new IllegalArgumentException(Messages.ERROR_ORDER.getMessage()+"중복!");
                }else{
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
            if (menuList.getOrderableMenuList().contains(order.getMenu())) {
                return true;
            }
        }
        throw new IllegalArgumentException(Messages.ERROR_ORDER.getMessage()+ "음료만");
//        return false;
    }

    private boolean validateOrderCount(Set<Order> orders) {
        int count = 0;
        for (Order order : orders) {
            count += order.getCount();
        }
        if (count > 20) {
            throw new IllegalArgumentException(Messages.ERROR_ORDER.getMessage()+"20개 이상");
//            return false;
        }
        return true;
    }
}
