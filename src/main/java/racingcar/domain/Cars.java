package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private int maxMoveCount;

    private Cars(final List<Car> cars) {
        this.cars = cars;
        maxMoveCount = 0;
    }

    public static Cars of(final CarNames carNames) {
        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.getSize(); i++) {
            cars.add(Car.of(carNames.getCarName(i)));
        }
        return new Cars(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
            car.printMoveResult();
        }
    }

    public String getWinners() {
        String winners = "";
        for (Car car : cars) {
            if (car.getMoveCount() == maxMoveCount) {
                winners += ", " + car.getCarName().getName();
            }
        }
        return winners.substring(1);
    }

}
