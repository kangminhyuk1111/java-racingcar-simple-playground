package racingcar.domain.vo;

public record Repetition(int value) {

    public Repetition {
        validateRepetition(value);
    }

    private void validateRepetition(int repetition) {
        if (repetition < 0) {
            throw new IllegalArgumentException("반복 횟수는 최소 0 이상의 양수를 입력해주세요.");
        }
    }
}
