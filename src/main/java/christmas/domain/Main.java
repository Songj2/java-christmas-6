package christmas.domain;

public enum Main {
    STEAK(55000, "티본스테이크"),
    RIBS(54000, "바비큐립"),
    SEAFOOD(35000, "해산물파스타"),
    CHRISTMAS(25000, "크리스마스파스타");

    private final int price;
    private final String menu;
    Main(int price, String menu){
        this.price= price;
        this.menu= menu;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }
}
