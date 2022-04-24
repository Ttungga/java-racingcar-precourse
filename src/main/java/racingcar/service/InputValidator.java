package racingcar.service;

import java.util.regex.Pattern;
import racingcar.domain.ErrorMessage;

public class InputValidator {

    private static final Pattern carNamesInputNotAllowedCharacter = Pattern.compile("[^a-zA-Z0-9,]");

    public static void validateCarNamesInput(final String carNamesInput) {
        if (carNamesInputNotAllowedCharacter.matcher(carNamesInput).find()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAMES_INPUT_HAS_NOT_ALLOWED_CHARACTER.getMessage());
        }
    }
}
