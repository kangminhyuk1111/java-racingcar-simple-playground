package racingcar.domain.vo;

public record Name(String value) {

    public Name {
        validateName(value);
    }

    private void validateName(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 값이 작성될 수 없습니다.");
        }

        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능하다.");
        }
    }
}
