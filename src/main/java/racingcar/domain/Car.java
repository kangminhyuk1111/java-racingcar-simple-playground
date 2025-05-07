package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int MOVING_STANDARD = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(final RandomNumberGenerator randomNumberGenerator) {
        if (randomNumberGenerator.generate() >= MOVING_STANDARD) {
            position++;
        }
    }

    private void validateName(final String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 값이 작성될 수 없습니다.");
        }
    }
}
