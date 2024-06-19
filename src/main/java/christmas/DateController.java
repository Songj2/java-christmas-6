package christmas;

import christmas.domain.Date;
import christmas.domain.Messages;

public class DateController {
    private int date;
    private int discountDate;

    public DateController(int date){
        this.date= date;
        this.discountDate= dayDiscount(date);
    }

    public int getDiscountDate() {
        return discountDate;
    }

    private int dayDiscount(int date){
        if(date-1< Date.D_DAY.getDate()){
            return date-1;
        }
        return 0;
    }
}
