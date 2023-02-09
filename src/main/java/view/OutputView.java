package view;

import domain.Car;
import domain.Cars;
import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_RESULT_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE_FORMAT = "가 최종 우승했습니다.";
    private static final String NAME_DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(
                String.format(CAR_RESULT_FORMAT, car.getName(), car.getMovePosition()));
        }
        System.out.println();
    }

    public void printFinalResult(Cars cars) {
        List<Car> winners = cars.decideWinner();
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : winners) {
            stringBuilder.append(car.getName() + NAME_DELIMITER);
        }
        String winnerNames = stringBuilder.toString();
        System.out.print(winnerNames.substring(0, winnerNames.length()-1) + WINNER_MESSAGE_FORMAT);
    }
}
