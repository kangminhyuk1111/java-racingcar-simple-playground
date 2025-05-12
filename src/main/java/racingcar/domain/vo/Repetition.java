package racingcar.domain.vo;

public record Repetition(int value) {

    public static final int MIN_REPETITION = 0;

    public Repetition {
        validateRepetition(value);
    }

    private void validateRepetition(int repetition) {
        if (isUnderMinimumRepetition(repetition)) {
            throw new IllegalArgumentException("반복 횟수는 최소 0 이상의 양수를 입력해주세요.");
        }
    }

    private boolean isUnderMinimumRepetition(int repetition) {
        return repetition <= MIN_REPETITION;
    }
}
