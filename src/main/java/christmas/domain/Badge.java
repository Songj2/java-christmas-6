package christmas.domain;

public enum Badge {
    SANTA("산타",20000),
    TREE("트리",10000),
    STAR("별",5000);

    private final String badge;
    private final int price;
    Badge( String badge, int price){
        this.price= price;
        this.badge= badge;
    }

    public int getPrice() {
        return price;
    }

    public String getBadge() {
        return badge;
    }
}
