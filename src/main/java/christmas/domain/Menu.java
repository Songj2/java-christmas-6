package christmas.domain;

public enum Menu {
    SOUP("appetizer", 6000, "양송이수프"),
    TAPAS("appetizer", 5500, "타파스"),
    SALAD("appetizer", 8000, "시저샐러드"),

    STEAK("main", 55000, "티본스테이크"),
    RIBS("main", 54000, "바비큐립"),
    SEAFOOD("main", 35000, "해산물파스타"),
    CHRISTMAS("main", 25000, "크리스마스파스타"),

    CHOCO_CAKE("dessert", 15000, "초코케이크"),
    ICE_CREAM("dessert", 25000, "아이스크림"),

    ZERO_COKE("drink", 3000, "제로콜라"),
    RED_WINE("drink", 60000, "레드와인"),
    CHAMPAGNE("drink", 25000, "샴페인");

    private final String type;
    private final int price;
    private final String menu;

    Menu(String type, int price, String menu) {
        this.type = type;
        this.price = price;
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public String getMenu() {
        return menu;
    }

    public String getType() {
        return type;
    }

}
