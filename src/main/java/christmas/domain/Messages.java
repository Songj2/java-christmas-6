package christmas.domain;

public enum Messages {
    START_WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),

    INPUT_WHEN("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    ERROR_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),

    OUTPUT_START("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_ORDER("<주문 메뉴>"),
    OUTPUT_DISCOUNT_BEFORE("<할인 전 총주문 금액>"),
    OUTPUT_PRESENTATION("<증정 메뉴>"),
    OUTPUT_BENEFITS("<혜택 내역>"),
    OUTPUT_BENEFITS_PRICE("<총혜택 금액>"),
    OUTPUT_DISCOUNT_AFTER("<할인 후 예상 결제 금액>"),
    OUTPUT_BADGE("<12월 이벤트 배지>");
    private final String message;
    Messages(String message){
        this.message= message;
    }

public String getMessage(){
        return message;
}
}
