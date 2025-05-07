package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.TestRandomNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    
    @Test
    @DisplayName("게임 생성 및 실행 테스트")
    void createRacingGame() {
        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        List<Car> cars = Arrays.asList(car1, car2);

        RacingGame racingGame = new RacingGame(cars, new TestRandomNumberGenerator(new int[]{3,4}));

        final List<Car> winners = racingGame.start(6);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(6);
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void multipleWinners() {
        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        final Car car3 = new Car("car3");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        RacingGame racingGame = new RacingGame(cars,
                new TestRandomNumberGenerator(new int[]{9, 4, 2}));

        final List<Car> winners = racingGame.start(5);

        assertThat(winners).containsExactlyInAnyOrder(car1, car2);
        assertThat(winners).hasSize(2);
        assertThat(car1.getPosition()).isEqualTo(5);
        assertThat(car2.getPosition()).isEqualTo(5);
        assertThat(car3.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("모든 자동차가 움직이지 않는 경우 테스트")
    void noCarsMove() {
        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        List<Car> cars = Arrays.asList(car1, car2);

        RacingGame racingGame = new RacingGame(cars,
                new TestRandomNumberGenerator(new int[]{3, 2}));

        final List<Car> winners = racingGame.start(4);

        assertThat(winners).contains(car1, car2);
        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("다수의 우승자 테스트")
    void complexMovementPattern() {
        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        final Car car3 = new Car("car3");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        int[] values = {
                4, 3, 5,
                2, 7, 8,
                9, 1, 0,
                3, 4, 2
        };

        RacingGame racingGame = new RacingGame(cars, new TestRandomNumberGenerator(values));

        final List<Car> winners = racingGame.start(4);

        assertThat(winners).containsExactlyInAnyOrder(car1, car2, car3);
        assertThat(car1.getPosition()).isEqualTo(2);
        assertThat(car2.getPosition()).isEqualTo(2);
        assertThat(car3.getPosition()).isEqualTo(2);
    }
}
