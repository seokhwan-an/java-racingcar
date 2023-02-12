package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {"r", "ㄱ", ",", "0"})
    @DisplayName("시도 횟수 사용자 입력 값이 옳바른 지 검증하는 테스트")
    void validateRoundTest(String input){
        //Given
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //When
        Throwable result = catchThrowable(()->{inputView.readRacingRound();});

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}