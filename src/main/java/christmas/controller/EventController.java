package christmas.controller;

import christmas.domain.Order;
import christmas.domain.*;

import java.util.Map;
import java.util.Set;

public class EventController {
    public EventController() {
    }

    public int dDayEvent(int discountDay) {
        if (discountDay!=0){
            return EventPrice.DEFAULT.getPrice() + (discountDay * EventPrice.D_DAY_DISCOUNT.getPrice());
        }
        return 0;
    }

    public int weekEvent(int date, Set<Order> orders) {
        if (date % 7 == Date.WEEKEND_START.getDate() || date % 7 == Date.WEEKEND_END.getDate()) {
            return weekendDiscount(orders)* EventPrice.DAY_DISCOUNT.getPrice();
        }
        return weekDayDiscount(orders) * EventPrice.DAY_DISCOUNT.getPrice();
    }

    private int weekendDiscount(Set<Order> orders) {
        int discount = 0;
        for (Order order : orders) {
            discount+=compareMain(order);
        }
        return discount ;

    }
    private int compareMain(Order order){
        for (String menu : new MenuList().getMainMenuList().keySet()) {
            System.out.println(menu+order.getMenu());
            if (order.getMenu().equals(menu)) {
                 return order.getCount();
            }
        }
        return 0;
    }

    private int weekDayDiscount(Set<Order> orders) {
        int discount = 0;
        for (Order order : orders) {
            System.out.println(order.getMenu()+discount);
            discount+=compareDessert(order);
        }
        return discount;

    }

    private int compareDessert(Order order) {
        for (String menu : new MenuList().getDessertMenuList().keySet()) {
            System.out.println(menu+order.getMenu());
                if (order.getMenu().equals(menu)) {
                    return order.getCount();
                }
        }
        return 0;
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
