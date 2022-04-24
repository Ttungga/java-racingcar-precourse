package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNamesFactoryTest {

    private final CarNamesFactory carNamesFactory = new CarNamesFactory();

    @Test
    void 올바른_형식의_입력값이_들어오면_CarNames_객체가_생성되어야_한다() {
        // given
        final String[] carNamesInputArray = {"a,b,c", "1,2,3", "car1,car2,car3", "abcde,12345,qwer"};

        // when and then
        for (String carNamesInput : carNamesInputArray) {
            final String[] carNameArray = carNamesInput.split(",");
            final CarNames carNames = carNamesFactory.create(carNamesInput);
            assertThat(carNames).isNotNull();
            assertThat(carNames.getSize()).isEqualTo(carNameArray.length);
            assertThat(carNames.getCarName(0)).isEqualTo(carNameArray[0]);
            assertThat(carNames.getCarName(1)).isEqualTo(carNameArray[1]);
            assertThat(carNames.getCarName(2)).isEqualTo(carNameArray[2]);
        }
    }

    @Test
    void 문자_숫자_컴마가_아닌_값이_입력값에_포함되어_있으면_IllegalArgumentException이_반환된다() {
        // given
        final String[] carNamesInputArray = {"car1,car2, ", "car1,car@,car2", "car1,\r\n,car2", "car1,자동차,car2"};

        // when and then
        for (String carNamesInput : carNamesInputArray) {
            assertThatThrownBy(() -> carNamesFactory.create(carNamesInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 한_개_이하의_자동차_이름이_들어오면_IllegalArgumentException이_반환된다() {
        // given
        final String[] carNamesInputArray = {",", "a", "a,", ",a"};

        // when and then
        for (String carNamesInput : carNamesInputArray) {
            assertThatThrownBy(() -> carNamesFactory.create(carNamesInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 자동차_이름이_1자_미만_6자_이상인_경우가_있으면_IllegalArgumentException이_반환된다() {
        // given
        final String[] carNamesInputArray = {"a,123456", "a", "a,", ",a"};

        // when and then
        for (String carNamesInput : carNamesInputArray) {
            assertThatThrownBy(() -> carNamesFactory.create(carNamesInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 중복된_자동차_이름이_있으면_IllegalArgumentException이_반환된다() {
        // given
        final String[] carNamesInputArray = {"a,a", "1,b,c,1", "a,car1,b,car1,c"};

        // when and then
        for (String carNamesInput : carNamesInputArray) {
            assertThatThrownBy(() -> carNamesFactory.create(carNamesInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}
