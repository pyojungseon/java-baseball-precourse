package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    public void run() {
        boolean reGame=true;
        BaseBallJudge judge = new BaseBallJudge();
        BaseBallBall ballNumber = new BaseBallBall();
        ballNumber.makeRandomNumber();

        while(reGame) {
            System.out.println(Constants.INPUT_NUMBER_MENT);
            String number = Console.readLine();

            // exception 처리
            this.isArgLengthOverThree(number);

            //숫자 심판 후 출력
            judge.judgeNumber(number, ballNumber.getNumber());
            judge.printJudge();

            //end 조건 확인
            reGame=judge.isReGame();
            ballNumber.makeNewNumber(judge, reGame);
        }
    }

    public void isArgLengthOverThree(String number){
        if (number.length()>3) {
            throw new IllegalArgumentException();
        }
    }
}
