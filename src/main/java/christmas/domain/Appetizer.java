package christmas.domain;

public enum Appetizer {
    SOUP(6000, "양송이수프"),
    TAPAS(5500, "타파스"),
    SALAD(8000, "시저샐러드");

    private final int price;
    private final String menu;
    Appetizer (int price, String menu){
        this.price= price;
        this.menu= menu;
    }

    public int getPrice() {
        return price;
    }

    public String getMenu() {
        return menu;
    }
}
