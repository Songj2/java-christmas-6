package christmas;

import christmas.domain.Date;
import christmas.domain.Messages;

public class Validate {
    public boolean validateDate(String date){
        return validateNumber(date)&& validateRange(Integer.parseInt(date));
    }

    private boolean validateNumber(String date){
        try {
            if (date.matches("^[0-9]+$")){
                return true;
            }
            throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println(Messages.ERROR_DATE.getMessage());
            return false;
        }
    }

    private boolean validateRange(int date){
        try {
            if (Date.EVENT_START.getDate() > date || Date.EVENT_END.getDate() < date) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(Messages.ERROR_DATE.getMessage());
            return false;
        }
        return true;
    }
}
