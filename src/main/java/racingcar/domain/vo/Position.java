package racingcar.domain.vo;

public record Position(int value) {

    public Position() {
        this(0);
    }

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다.");
        }
        this.value = value;
    }

    public Position forward() {
        return new Position(value + 1);
    }
}
