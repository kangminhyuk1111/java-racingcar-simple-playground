package racingcar.domain;

import racingcar.domain.vo.Winners;
import racingcar.util.RandomNumberGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record Cars(List<Car> value) {

    public Cars {
        validateDuplicateNames(value);
    }

    public void moveCars(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : value) {
            car.move(randomNumberGenerator);
        }
    }

    public Winners findWinners() {
        int maxPosition = value.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return new Winners(value.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList());
    }

    private void validateDuplicateNames(List<Car> value) {
        Set<String> uniqueNames = value.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (uniqueNames.size() < value.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}
