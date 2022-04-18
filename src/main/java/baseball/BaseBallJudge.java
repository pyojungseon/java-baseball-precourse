package baseball;

public class BaseBallJudge {
    public boolean isThreeStrike(int[] judge) {
        if (judge[Constants.IS_STRIKE]==3) {
            System.out.println(Constants.THREE_STRIKE_MENT);
            System.out.println(Constants.DO_YOU_WANT_REGAME_MENT);
            return true;
        }
        return false;
    }

    public void printJudge(int[] judge) {
        StringBuilder ans = new StringBuilder();
        if (judge[Constants.IS_BALL]>0) {
            ans.append(judge[Constants.IS_BALL]+Constants.BALL+" ");
        }
        if (judge[Constants.IS_STRIKE]>0) {
            ans.append(judge[Constants.IS_STRIKE]+Constants.STRIKE+" ");
        }
        if (judge[Constants.IS_BALL]==0 && judge[Constants.IS_STRIKE]==0) {
            ans.append(Constants.NOTHING);
        }
        System.out.println(ans.toString().trim());
    }

    public int[] judgeNumber(String number, String ansNumber) {
        int[] judge = {0, 0};
        for (int i = 0; i < number.length(); i++) {
            int strike = checkStrike(number.charAt(i), ansNumber.charAt(i));
            int ball = checkBall(ansNumber, number.charAt(i));
            judge[Constants.IS_STRIKE]+=strike;
            judge[Constants.IS_BALL]=judge[Constants.IS_BALL]+ball-strike;
        }
        return judge;
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
}
