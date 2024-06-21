package christmas.domain;

public enum EventPrice {
    DEFAULT(1000),
    D_DAY_DISCOUNT(100),
    DAY_DISCOUNT(2023),
    PRESENTATION(25000),
    PRESENTATION_STANDARD(120000);

    private final int price;
    EventPrice(int prince){
        this.price= prince;
    }

    public int getPrice() {
        return price;
    }
}
