package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class eventTest {
    private EventController eventController = new EventController();

    @Test
    @DisplayName("디데이 이벤트 테스트")
    public void dDayEventTest() {
        assertAll("dDayEvent",
                () -> assertThat(eventController.dDayEvent(24)).isEqualTo(3400),
                () -> assertThat(eventController.dDayEvent(0)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("요일 이벤트 테스트")
    public void weekEvent() {
        Set<Order> orders = new HashSet<>();
        orders.add(new Order("초코케이크-1"));
        orders.add(new Order("티본스테이크-2"));
        assertAll("weekEvent",
                () -> assertThat(eventController.weekEvent(3, orders)).isEqualTo(2023),
                () -> assertThat(eventController.weekEvent(8, orders)).isEqualTo(4046)
        );
    }

    @Test
    @DisplayName("특별 이벤트 테스트")
    public void specialEventTest() {
        assertAll("specialEvent",
                () -> assertThat(eventController.specialDiscount(10)).isEqualTo(1000),
                () -> assertThat(eventController.specialDiscount(4)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("증정 이벤트 테스트")
    public void presentationEventTest() {
        assertAll("presentationEvent",
                () -> assertThat(eventController.presentationEvent(120000)).isEqualTo(25000),
                () -> assertThat(eventController.presentationEvent(90000)).isEqualTo(0)
        );
    }
}
