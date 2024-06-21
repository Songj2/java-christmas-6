package christmas;

import christmas.domain.*;

import java.util.Map;
import java.util.Set;

public class EventController {
    public EventController() {
    }

    public int dDayEvent(int discountDay) {
        return EventPrice.DEFAULT.getPrice() + (discountDay * EventPrice.D_DAY_DISCOUNT.getPrice());
    }

    public int weekEvent(int date, Set<Order> orders) {
        if (date % 7 == Date.WEEKEND_START.getDate() || date % 7 == Date.WEEKEND_END.getDate()) {
            return weekendDiscount(orders) * EventPrice.DAY_DISCOUNT.getPrice();
        }
        return weekdayDiscount(orders);
    }

    private int weekendDiscount(Set<Order> orders) {
        Main[] mains = Main.values();
        int discount = 0;
        for (Order order : orders) {
            for (Main main : mains) {
                if (order.getMenu().equals(main.getMenu())) {
                    discount += order.getCount();
                }
            }
        }
        return discount + EventPrice.DAY_DISCOUNT.getPrice();

    }

    private int weekdayDiscount(Set<Order> orders) {
        Dessert[] mains = Dessert.values();
        int discount = 0;
        for (Order order : orders) {
            for (Dessert dessert : mains) {
                if (order.getMenu().equals(dessert.getMenu())) {
                    discount += order.getCount();
                }
            }
        }
        return discount;
    }

    public int specialDiscount(int date){
        if (date%7== Date.SPECIAL_EVENT.getDate()){
            return EventPrice.DEFAULT.getPrice();
        }
        return 0;
    }
    public int calTotalPriceBeforeDiscount(Set<Order> orders) {
        MenuList menuList = new MenuList();
        int total = 0;
        for (Order order : orders) {
            total += Menu.valueOf(menuList.getAllMenuList().get(order.getMenu())).getPrice() * order.getCount();
        }
        return total;
    }

    public int calTotalDiscount(Map<String, Integer> benefits){
        int total=0;
        for (String benefit: benefits.keySet()){
            total+= benefits.get(benefit);
        }
        return total;
    }
    public int presentationEvent(int total) {
        if (total >= EventPrice.PRESENTATION_STANDARD.getPrice()) {
            return EventPrice.PRESENTATION.getPrice();
        }
        return 0;
    }
}
