package christmas;

import christmas.domain.MenuList;
import christmas.domain.Messages;


public class Order {
    private String menu;
    private int count;
    private Validate validate = new Validate();
    private MenuList menuList = new MenuList();

    public Order(String order) {
        if (validate(order)) {
            this.menu = order.split("-")[0];
            this.count = Integer.parseInt(order.split("-")[1]);
        }
    }

    public String getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }

    private boolean validate(String order) {
        String[] temp = order.split("-");
        return validateMenu(temp[0]) && validateCount(temp[1]);
    }

    private boolean validateMenu(String menu) {
        if (menuList.getAllMenuList().contains(menu)){
            return true;
        }
        throw new IllegalArgumentException(Messages.ERROR_ORDER.getMessage()+"없는 메뉴");
//        return false;
    }

    private boolean validateCount(String count) {
        if (validate.validateNumber(count)){
            return true;
        }
        throw new IllegalArgumentException(Messages.ERROR_ORDER.getMessage()+"개수 이상");
//        return false;
    }
}
