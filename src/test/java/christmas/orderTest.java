package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


public class orderTest extends NsTest {
    private final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    @Test
    @DisplayName("주문 개수 테스트")
    void orderCountTest() {
        assertSimpleTest(() -> {
            runException("3", "타파스-12,제로콜라-20");
            assertThat(output().contains(ERROR_MESSAGE));
        });
    }

    @Test
    @DisplayName("메뉴 중복 테스트")
    void orderDuplicatedTest() {
        assertSimpleTest(() -> {
            runException("3", "타파스-1,타파스-2");
            assertThat(output().contains(ERROR_MESSAGE));
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
