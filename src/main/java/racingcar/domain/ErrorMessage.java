package racingcar.domain;

public enum ErrorMessage {

    CAR_NAMES_HAS_NOT_ALLOWED_CHARACTER("[ERROR] 자동차 이름은 공백없이 문자 또는 숫자만 가능합니다"),
    CAR_NAMES_LESS_THAN_TWO("[ERROR] 자동차 이름은 2개 이상이어야 합니다"),
    EMPTY_CAR_NAME_OR_LENGTH_OVER_FIVE("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다"),
    CAR_NAMES_DUPLICATED("[ERROR] 각 자동차 이름은 중복될 수 없습니다"),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
