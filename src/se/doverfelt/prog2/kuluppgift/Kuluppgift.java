package se.doverfelt.prog2.kuluppgift;

/**
 * Created by rickard on 2016-01-20.
 */
public class Kuluppgift {

    public static void main(String[] args) {

    }

    private CompState compareBalls(Ball[] b1, Ball[] b2) {
        int sum1 = 0, sum2 = 0;
        for (Ball b : b1) {
            sum1 += b.weight;
        }
        for (Ball b : b2) {
            sum2 += b.weight;
        }
        if (sum1 > sum2) {
            return CompState.GT;
        } else if (sum1 < sum2) {
            return CompState.LT;
        } else {
            return CompState.EQUAL;
        }
    }

    public void solve(Ball[] balls) {
        Ball[][] firstSplit = new Ball[4][3];
        for (int i = 0; i < firstSplit.length; i++) {
            for (int j = 0; j < 3; j++) {
                firstSplit[i][j] = balls [j+(3*i)];
            }
        }

        if (compareBalls(firstSplit[0], firstSplit[1]) != CompState.EQUAL) {
            solveScndState(firstSplit[0], firstSplit[1], firstSplit[4], compareBalls(firstSplit[0], firstSplit[1]));
        } else {

        }

    }

    private void solveScndState(Ball[] balls, Ball[] balls2, Ball[] reference, CompState compState) {
        CompState newCompState = compareBalls(balls, reference);
        CompState referenceState = newCompState;
        if (newCompState == CompState.EQUAL) {
            referenceState = compState;
        }

        

    }

}
