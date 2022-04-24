package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    void 올바른_형식의_입력값이_들어오면_TryCount_객체가_생성되어야_한다() {
        // given
        final String tryCountInput = "9";

        // when
        final TryCount tryCount = TryCount.of(tryCountInput);

        // then
        assertThat(tryCount).isNotNull();
        assertThat(tryCount.getTryCount()).isEqualTo(9);
    }

    @Test
    void 입력값이_숫자가_아니면_IllegalArgumentException이_반환된다() {
        // given
        final String tryCountInput = "text";

        // when and then
        assertThatThrownBy(() -> TryCount.of(tryCountInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_숫자이나_1보다_작거나_10보다_크면_IllegalArgumentException이_반환된다() {
        // given
        final String[] tryCountInputArray = {"0", "11"};

        // when and then
        for (String tryCountInput : tryCountInputArray) {
            assertThatThrownBy(() -> TryCount.of(tryCountInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}
