package implement;

import java.util.Scanner;

class Knight {

    private static final int LIMIT_COLUMN = 'h';
    private static final int LIMIT_ROW = 8;

    private static final int[][] MOVE_TERMS = new int[][]{
        {1, 2}, {1, -2}, {2, 1}, {2, -1},
        {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String position = sc.nextLine();

        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));

        int count = 0;

        for (int i = 0; i < MOVE_TERMS.length; i++) {
            int moveColumn = MOVE_TERMS[i][0];
            int moveRow = MOVE_TERMS[i][1];

            if (movable(column + moveColumn)
                && movable(row + moveRow)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean movable(int position) {
        if ((position >= 'a' && position <= LIMIT_COLUMN)
            || (position >= 1 && position <= LIMIT_ROW)) {
            return true;
        }
        return false;
    }

}
