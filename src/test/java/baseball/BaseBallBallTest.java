package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallBallTest {

    @Test
    void getNumberTest() {
        BaseBallBall ball = new BaseBallBall();
        ball.makeRandomNumber();
        assertThat(ball.getNumber()).hasSize(3);
    }
}
