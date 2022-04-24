package racingcar.domain;

import java.util.regex.Pattern;

public class CarNamesFactory {

    private static final Pattern notAllowedCharacterPattern = Pattern.compile("[^a-zA-Z0-9,]");

    public CarNames create(final String carNamesInput) {
        validateNotAllowedCharacter(carNamesInput);
        return CarNames.of(carNamesInput.split(","));
    }

    private void validateNotAllowedCharacter(final String carNamesInput) {
        if (notAllowedCharacterPattern.matcher(carNamesInput).find()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAMES_INPUT_HAS_NOT_ALLOWED_CHARACTER.getMessage());
        }
    }

}
