package racingcar.domain;

import java.util.List;

public class CarNames {

    private final List<CarName> carNames;

    private CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static CarNames of(final List<CarName> carNames) {
        return new CarNames(carNames);
    }

    public int getSize() {
        return carNames.size();
    }

    public String getCarName(final int index) {
        return carNames.get(index).getCarName();
    }

}
