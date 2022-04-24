package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CarNamesFactory {

    private static final Pattern notAllowedCharacterPattern = Pattern.compile("[^a-zA-Z0-9,]");

    public CarNames create(final String carNamesInput) {
        validateNotAllowedCharacter(carNamesInput);
        final String[] carNameArray = carNamesInput.split(",");
        validateCarNamesSize(carNameArray);
        return CarNames.of(createCarNameList(carNameArray));
    }

    private List<CarName> createCarNameList(final String[] carNameArray) {
        final Set<String> carNameSet = new HashSet<>();
        final List<CarName> carNameList = new ArrayList<>();
        for (String carName : carNameArray) {
            validateCarNameLength(carName);
            carNameSet.add(carName);
            carNameList.add(CarName.of(carName));
        }
        validateDuplicatedCarName(carNameSet, carNameList);
        return carNameList;
    }

    private void validateNotAllowedCharacter(final String carNamesInput) {
        if (notAllowedCharacterPattern.matcher(carNamesInput).find()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNamesSize(final String[] carNameArray) {
        if (carNameArray.length < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameLength(final String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedCarName(final Set<String> carNameSet, final List<CarName> carNameList) {
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException();
        }
    }

}
