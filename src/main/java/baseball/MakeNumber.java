package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class MakeNumber {
    public String makeNewNumber(boolean threeStrike, boolean reGame, String ansNumber) {
        if (threeStrike && reGame) {
            return this.makeRandomNumber();
        }
        return ansNumber;
    }

    public String makeRandomNumber() {
        StringBuilder ansNumber = new StringBuilder();
        while(ansNumber.length()<3) {
            int rdNumber = Randoms.pickNumberInRange(0, 9);
            this.addUniqueNumber(ansNumber, rdNumber);
        }
        return ansNumber.toString();
    }

    public void addUniqueNumber(StringBuilder ansNumber, int rdNumber) {
        if (ansNumber.indexOf(String.valueOf(rdNumber))==-1) {
            ansNumber.append(rdNumber);
        }
    }
}
