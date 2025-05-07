package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.ui.OutputView;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class RacingController {

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingController(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void playGame(List<String> carNames, int repetition) {
        final List<Car> cars = createCars(carNames);

        final RacingGame game = new RacingGame(cars, randomNumberGenerator);

        OutputView.printGameStart();

        for (int i = 0; i < repetition; i++) {
            game.moveCars();
            OutputView.printRoundResult(game.getCars());
        }

        OutputView.printWinners(game.findWinners());
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
