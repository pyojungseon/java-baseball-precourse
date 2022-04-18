package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallJudge {

    private int strike;
    private int ball;

    public BaseBallJudge() {
        setNewCount();
    }

    public void setNewCount() {
        strike=0;
        ball=0;
    }

    public boolean isThreeStrike() {
        if (strike==3) {
            System.out.println(Constants.THREE_STRIKE_MENT);
            System.out.println(Constants.DO_YOU_WANT_REGAME_MENT);
            return true;
        }
        return false;
    }

    public void printJudge() {
        StringBuilder ans = new StringBuilder();
        if (ball>0) {
            ans.append(ball+Constants.BALL+" ");
        }
        if (strike>0) {
            ans.append(strike+Constants.STRIKE+" ");
        }
        if (ball==0 && strike==0) {
            ans.append(Constants.NOTHING);
        }
        System.out.println(ans.toString().trim());
    }

    public void judgeNumber(String number, String ansNumber) {
        setNewCount();
        for (int i = 0; i < number.length(); i++) {
            int strike = checkStrike(number.charAt(i), ansNumber.charAt(i));
            int ball = checkBall(ansNumber, number.charAt(i));
            this.strike+=strike;
            this.ball=this.ball+ball-strike;
        }
    }

    public int checkStrike(char number, char ansNumber) {
        if (number == ansNumber) {
            return 1;
        }
        return 0;
    }

    public int checkBall(String ansNumber, char number) {
        if (ansNumber.indexOf(number) > -1) {
            return 1;
        }
        return 0;
    }

    public boolean isReGame() {
        if(this.isThreeStrike()) {
            return getReGame();
        }
        return true;
    }

    public boolean getReGame() {
        String exit = Console.readLine();
        if (Integer.valueOf(exit) == Constants.END) {
            System.out.println(Constants.GAME_OVER_MENT);
            return false;
        }
        return true;
    }
}
