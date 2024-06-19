package christmas.domain;

import christmas.DateController;
import christmas.InputViewer;
import christmas.Validate;

public class RunApplication {
    private InputViewer inputViewer= new InputViewer();
    private Validate validate= new Validate();
    private DateController dateController;

    public RunApplication() {
        int date= Integer.parseInt(inputDate());
        dateController= new DateController(date);
        int discountDate= dateController.getDiscountDate();
    }

    private String inputDate() {
        String date;
        do {
            date = inputViewer.readDate();
        }
        while (!validate.validateDate(date));
        return date;
    }
}
