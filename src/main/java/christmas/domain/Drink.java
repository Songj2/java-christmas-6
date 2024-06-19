package christmas.domain;

public enum Drink {
    ZERO_COKE(3000, "제로콜라"),
    RED_WINE(60000, "레드와인"),
    CHAMPAGNE(25000, "샴페인");

    private final int price;
    private final String menu;

    Drink(int price, String menu) {
        this.price = price;
        this.menu = menu;
    }
}
