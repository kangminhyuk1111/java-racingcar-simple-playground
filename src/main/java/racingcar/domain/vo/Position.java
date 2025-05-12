package racingcar.domain.vo;

public record Position(int value) {
    private static final int MIN_VALUE = 0;

    public Position() {
        this(MIN_VALUE);
    }

    public Position {
        validatePosition(value);
    }

    public Position forward() {
        return new Position(value + 1);
    }

    private void validatePosition(int value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다.");
        }
    }

    private boolean isNegative(int value) {
        return value < MIN_VALUE;
    }
}