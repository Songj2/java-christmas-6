package christmas;

import christmas.domain.Date;
import christmas.domain.Messages;

public class Validate {
    public boolean validateDate(String date) {
        try {
            return validateNumber(date) && validateRange(Integer.parseInt(date));
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_DATE.getMessage());
            return false;
        }

    }

    public boolean validateNumber(String date) {
        if (date.matches("^[0-9]+$")) {
            return true;
        }
        throw new IllegalArgumentException();

    }

    private boolean validateRange(int date) {
        if (Date.EVENT_START.getDate() > date || Date.EVENT_END.getDate() < date) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
