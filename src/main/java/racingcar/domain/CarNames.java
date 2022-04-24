package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {

    private final List<CarName> carNames;

    private CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static CarNames of(final List<CarName> carNames) {
        return new CarNames(carNames);
    }

    public static CarNames of(final String[] carNameArray) {
        validateCarNamesSize(carNameArray);
        final List<CarName> carNameList = new ArrayList<>();
        final Set<String> carNameSet = new HashSet<>();
        for (String carName : carNameArray) {
            carNameList.add(CarName.of(carName));
            carNameSet.add(carName);
        }
        validateCarNamesDuplication(carNameList, carNameSet);
        return new CarNames(carNameList);
    }

    private static void validateCarNamesSize(final String[] carNameArray) {
        if (carNameArray.length < 2) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAMES_LESS_THAN_TWO.getMessage());
        }
    }

    private static void validateCarNamesDuplication(final List<CarName> carNameList, final Set<String> carNameSet) {
        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAMES_DUPLICATED.getMessage());
        }
    }

    public int getSize() {
        return carNames.size();
    }

    public CarName getCarName(final int index) {
        return carNames.get(index);
    }

}
