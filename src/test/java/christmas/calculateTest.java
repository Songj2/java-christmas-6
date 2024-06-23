package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculateTest {
    private final EventController eventController= new EventController();

    @Test
    @DisplayName("할인 전 금액 계산 테스트")
    public void calTotalPriceBeforeDiscountTest(){
        Set<Order> orders = new HashSet<>();
        orders.add(new Order("초코케이크-1"));
        orders.add(new Order("티본스테이크-2"));
        assertEquals(eventController.calTotalPriceBeforeDiscount(orders), 125000);
    }

    @Test
    @DisplayName("총 할인 금액 계산 테스트")
    public void calTotalDiscountTest(){
        Map<String, Integer> benefits= new HashMap<>();
        benefits.put("증정 이벤트", 25000);
        benefits.put("요일 이벤트", 2023);
        assertEquals(eventController.calTotalDiscount(benefits), 27023);
    }
}
