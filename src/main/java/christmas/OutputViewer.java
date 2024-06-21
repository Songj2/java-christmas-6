package christmas;

import christmas.domain.Badge;
import christmas.domain.Messages;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class OutputViewer {
    private final DecimalFormat priceFormater = new DecimalFormat("###,###");

    public void printMenu(Set<Order> orders) {
        System.out.println(Messages.OUTPUT_ORDER.getMessage());
        for (Order order : orders) {
            System.out.println(order.getMenu() + " " + order.getCount() + "개");
        }
        System.out.println();
    }

    public void printPrice(int price, String message) {
        System.out.println(message);
        String printValue = "없음";
        if (price != 0) {
            printValue = priceFormater.format(price) + "원";
        }
        System.out.println(printValue + "\n");
    }

    public void printPresentation(Map<String, Integer> benefits) {
        System.out.println(Messages.OUTPUT_PRESENTATION.getMessage());
        String printValue = "없음";
        if (benefits.containsKey("증정 이벤트")) {
            printValue = "샴페인 1개";
        }
        System.out.println(printValue + "\n");
    }

    public void printBenefits(Map<String, Integer> benefits) {
        System.out.println(Messages.OUTPUT_BENEFITS.getMessage());
        switch (benefits.size()) {
            case 0:
                System.out.println("없음");
            default:
                for (String benefit : benefits.keySet()) {
                    System.out.println(benefit + ": -" + benefits.get(benefit) + "원\n");
                }
        }
        System.out.println();
    }

    public void printBadge(int price) {
        System.out.println(Messages.OUTPUT_BADGE.getMessage());
        String printValue = "없음";
        if (price >= Badge.SANTA.getPrice()) {
            printValue = Badge.SANTA.getBadge();
        } else if (price >= Badge.TREE.getPrice()) {
            printValue = Badge.TREE.getBadge();
        } else if (price >= Badge.STAR.getPrice()) {
            printValue = Badge.STAR.getBadge();
        }
        System.out.println(printValue + "\n");
    }

}
