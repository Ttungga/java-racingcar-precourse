package racingcar.domain;

public class Car {

    private final CarName carName;
    private int moveCount;
    private String moveResult;

    private Car(final CarName carName) {
        this.carName = carName;
        moveCount = 0;
        moveResult = carName + ": ";
    }

    static Car of(final CarName carName) {
        return new Car(carName);
    }

    public CarName getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
