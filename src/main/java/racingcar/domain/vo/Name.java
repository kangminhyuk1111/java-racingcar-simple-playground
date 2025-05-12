package racingcar.domain.vo;

public record Name(String value) {

    public Name {
        validateName(value);
    }

    private void validateName(final String name) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException("이름은 빈 값이 작성될 수 없습니다.");
        }

        if (isTooLong(name)) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능하다.");
        }
    }

    private boolean isNullOrEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }

    private boolean isTooLong(String name) {
        return name.trim().length() > 5;
    }
}
