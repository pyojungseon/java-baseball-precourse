package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallBall {

    private boolean threeStrike;
    private String number;

    public BaseBallBall() {
        threeStrike=false;
        number="";
    }

    public String getNumber() {
        return number;
    }

    public void makeNewNumber(BaseBallJudge judge, boolean reGame) {
        threeStrike = judge.isThreeStrike();
        if (threeStrike && reGame) {
            this.makeRandomNumber();
            judge.setNewCount();
        }
    }

    public void makeRandomNumber() {
        StringBuilder ansNumber = new StringBuilder();
        while(ansNumber.length()<3) {
            int rdNumber = Randoms.pickNumberInRange(0, 9);
            this.addUniqueNumber(ansNumber, rdNumber);
        }
        number=ansNumber.toString();
    }

    public void addUniqueNumber(StringBuilder ansNumber, int rdNumber) {
        if (ansNumber.indexOf(String.valueOf(rdNumber))==-1) {
            ansNumber.append(rdNumber);
        }
    }
}
