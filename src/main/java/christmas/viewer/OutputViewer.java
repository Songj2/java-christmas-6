package christmas.viewer;

import christmas.domain.Badge;
import christmas.domain.Messages;
import christmas.domain.Order;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OutputViewer {
    private final DecimalFormat priceFormater = new DecimalFormat("###,###");
    private int date;
    private int totalBefore;
    private int benefitAmount;
    private int discountAmount;
    private Set<Order> orders = new HashSet<>();
    private Map<String, Integer> benefits = new HashMap<>();

    public OutputViewer(int date, Set<Order> orders, int totalBefore, int benefitAmount,int discountAmount, Map<String, Integer> benefits) {
        this.date = date;
        this.totalBefore = totalBefore;
        this.discountAmount = discountAmount;
        this.orders = orders;
        this.benefits = benefits;
        this.benefitAmount= benefitAmount;
        System.out.println("12월 " + date + Messages.OUTPUT_START.getMessage() + "\n");
        printResult();
    }

    private void printResult() {
        printMenu();
        printPrice(totalBefore, Messages.OUTPUT_DISCOUNT_BEFORE.getMessage());
        printPresentation();
        printBenefits();
        printPrice(benefitAmount, Messages.OUTPUT_BENEFITS_PRICE.getMessage());
        printPrice(totalBefore - discountAmount, Messages.OUTPUT_DISCOUNT_AFTER.getMessage());
        printBadge();
    }

    private void printMenu() {
        System.out.println(Messages.OUTPUT_ORDER.getMessage());
        for (Order order : orders) {
            System.out.println(order.getMenu() + " " + order.getCount() + "개");
        }
        System.out.println();
    }

    private void printPrice(int price, String message) {
        System.out.println(message);
        String printValue = "없음";
        if (price != 0) {
            printValue = priceFormater.format(price) + "원";
        }
        System.out.println(printValue + "\n");
    }

    private void printPresentation() {
        System.out.println(Messages.OUTPUT_PRESENTATION.getMessage());
        String printValue = "없음";
        if (benefits.containsKey("증정 이벤트") &&benefits.get("증정 이벤트")>0) {
            printValue = "샴페인 1개";
        }
        System.out.println(printValue + "\n");
    }

    private void printBenefits() {
        System.out.println(Messages.OUTPUT_BENEFITS.getMessage());
        String printValue = "없음";
        if (benefits.size() != 0) {
            printValue = "";
            for (String benefit : benefits.keySet()) {
                printValue += benefit + ": -" + priceFormater.format(benefits.get(benefit)) + "원\n";
            }
        }
        System.out.println(printValue + "\n");
    }

    private void printBadge() {
        System.out.println(Messages.OUTPUT_BADGE.getMessage());
        String printValue = "없음";
        if (benefitAmount >= Badge.SANTA.getPrice()) {
            printValue = Badge.SANTA.getBadge();
        } else if (benefitAmount >= Badge.TREE.getPrice()) {
            printValue = Badge.TREE.getBadge();
        } else if (benefitAmount >= Badge.STAR.getPrice()) {
            printValue = Badge.STAR.getBadge();
        }
        System.out.println(printValue + "\n");
    }

}
