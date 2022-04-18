package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseBallJudgeTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:0", "3:0"}, delimiter = ':')
    void strikeTest(char number, int strike) {
        BaseBallJudge judge = new BaseBallJudge();
        Assertions.assertEquals(judge.checkStrike(number, '1'), strike);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:1", "451:1", "789:0"}, delimiter = ':')
    void ballTest(String number, int strike) {
        BaseBallJudge judge = new BaseBallJudge();
        Assertions.assertEquals(judge.checkBall(number, '1'), strike);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true", "451:false", "862:false"}, delimiter = ':')
    void threeStrikeTest(String number, boolean isStrike) {
        BaseBallJudge judge = new BaseBallJudge();
        judge.judgeNumber(number, "123");
        Assertions.assertEquals(judge.isThreeStrike(), isStrike);
    }
}
