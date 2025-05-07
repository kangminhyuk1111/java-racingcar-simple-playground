package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(final List<Car> cars, final RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Car> start(final int repetition) {
        for (int i = 0; i < repetition; i++) {
            moveCars();
        }

        return findWinners();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(randomNumberGenerator);
        }
    }

    public List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
