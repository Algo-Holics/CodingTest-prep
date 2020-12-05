package greedy.cardgame;

import java.util.Scanner;

class CardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfRow = sc.nextInt();
        int numberOfColumn = sc.nextInt();

        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < numberOfRow; i++) {
            int minRowNumber = Integer.MAX_VALUE;
            for (int j = 0; j < numberOfColumn; j++) {
                int number = sc.nextInt();
                if (minRowNumber > number) {
                    minRowNumber = number;
                }
            }
            if (maxNumber < minRowNumber) {
                maxNumber = minRowNumber;
            }
        }

        System.out.println(maxNumber);
    }

}
