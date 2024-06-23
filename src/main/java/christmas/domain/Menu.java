package christmas.domain;

public enum Menu {
    SOUP("Appetizer", 6000, "양송이수프"),
    TAPAS("Appetizer", 5500, "타파스"),
    SALAD("Appetizer", 8000, "시저샐러드"),

    STEAK("Main", 55000, "티본스테이크"),
    RIBS("Main", 54000, "바비큐립"),
    SEAFOOD("Main", 35000, "해산물파스타"),
    CHRISTMAS("Main", 25000, "크리스마스파스타"),

    CHOCO_CAKE("Dessert", 15000, "초코케이크"),
    ICE_CREAM("Dessert", 25000, "아이스크림"),

    ZERO_COKE("Drink", 3000, "제로콜라"),
    RED_WINE("Drink", 60000, "레드와인"),
    CHAMPAGNE("Drink", 25000, "샴페인");

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
