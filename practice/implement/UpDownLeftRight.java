package implement;

import java.util.Scanner;

class UpDownLeftRight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxPos = Integer.parseInt(sc.nextLine());

        int currentRowPos = 0;
        int currentColumnPos = 0;

        String plan = sc.nextLine();
        for (char moveCommand : plan.toCharArray()) {
            if (moveCommand == 'L'
                && moveablePos(currentColumnPos, maxPos, -1)) {
                currentColumnPos--;
            } else if (moveCommand == 'R'
                && moveablePos(currentColumnPos, maxPos, 1)) {
                currentColumnPos++;
            } else if (moveCommand == 'U'
                && moveablePos(currentRowPos, maxPos, -1)) {
                currentRowPos--;
            } else if (moveCommand == 'D'
                && moveablePos(currentRowPos, maxPos, 1)) {
                currentRowPos++;
            }
        }

        System.out.println(currentRowPos + 1 + " " + (currentColumnPos + 1));
    }

    private static boolean moveablePos(
        int currentPos,
        int maxPos,
        int movedDistance) {
        int movedPos = currentPos + movedDistance;
        if ( movedPos >= 0 && movedPos < maxPos) {
            return true;
        }
        return false;
    }

}
