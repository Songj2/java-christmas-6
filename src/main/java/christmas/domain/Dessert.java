package christmas.domain;

public enum Dessert {
    CHOCO_CAKE(15000, "초코케이크"),
    ICE_CREAM(25000, "아이스크림");

    private final int price;
    private final String menu;

    Dessert(int price, String menu) {
        this.price = price;
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public String getMenu() {
        return menu;
    }
}
