package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.vo.Name;
import racingcar.domain.vo.Repetition;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class RacingController {

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingController(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void playGame() {
        final Repetition repetition = new Repetition(InputView.inputRacingCount());
        final Cars cars = createCars(InputView.inputCarNames());

        final RacingGame game = new RacingGame(cars, randomNumberGenerator);

        OutputView.printGameStart();

        for (int i = 0; i < repetition.value(); i++) {
            game.moveCars();
            OutputView.printRoundResult(game.getCars());
        }

        OutputView.printWinners(game.getCars());
    }

    private Cars createCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(name -> new Car(new Name(name)))
                .toList());
    }
}
