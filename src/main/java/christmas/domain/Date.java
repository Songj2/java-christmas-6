package christmas.domain;

public enum Date {
    EVENT_START(1),
    EVENT_END(31),
    D_DAY(25),
    WEEKEND_START(1),
    WEEKEND_END(2),
    SPECIAL_EVENT(3);


    private final int date;

    Date(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
