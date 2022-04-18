package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {

    public void run() {
        boolean reGame=true;
        BaseBallJudge refree = new BaseBallJudge();
        MakeNumber mn = new MakeNumber();
        String ansNumber = mn.makeRandomNumber();

        while(reGame) {
            //System.out.println(ansNumber);
            System.out.println(Constants.INPUT_NUMBER_MENT);
            String number = Console.readLine();

            // exception 처리
            this.isArgLengthOverThree(number);

            //숫자 심판 후 출력
            int[] judge = refree.judgeNumber(number, ansNumber);
            refree.printJudge(judge);

            //end 조건 확인
            boolean threeStrike = refree.isThreeStrike(judge);
            reGame = this.isContinue(threeStrike);
            ansNumber = mn.makeNewNumber(threeStrike, reGame, ansNumber);
        }
    }

    public void isArgLengthOverThree(String number){
        if (number.length()>3) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isContinue(boolean threeStrike) {
        if (threeStrike) {
            return getReGame();
        }
        return true;
    }

    public boolean getReGame(){
        String exit = Console.readLine();
        if (Integer.valueOf(exit)==Constants.END) {
            System.out.println(Constants.GAME_OVER_MENT);
            return false;
        }
        return true;
    }

}
