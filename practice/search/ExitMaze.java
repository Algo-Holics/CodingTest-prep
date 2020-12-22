package search;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ExitMaze {

    private static final int[][] MOVE = new int[][] {
        {-1, 0}, {1, 0}, {0, -1},{0, 1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Integer moveCount[][] = new Integer[N][M];
        Boolean map[][] = new Boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '1') {
                    map[i][j] = Boolean.TRUE;
                } else {
                    map[i][j] = Boolean.FALSE;
                }
            }
        }

        Queue<SimpleImmutableEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new SimpleImmutableEntry<>(0, 0));
        map[0][0] = Boolean.FALSE;
        moveCount[0][0] = 1;
        while (!queue.isEmpty()) {
            SimpleImmutableEntry<Integer, Integer> currentPosition = queue.poll();
            map[currentPosition.getKey()][currentPosition.getValue()] = Boolean.FALSE;
            Integer currentMove = moveCount[currentPosition.getKey()][currentPosition.getValue()];

            for (int z = 0; z < MOVE.length; z++) {
                int movedY = currentPosition.getKey() + MOVE[z][0];
                int movedX = currentPosition.getValue() + MOVE[z][1];

                if (movedY >= 0 && movedX >= 0
                    && movedY < N && movedX < M
                    && map[movedY][movedX].equals(Boolean.TRUE)) {
                    queue.add(new SimpleImmutableEntry<>(movedY, movedX));
                    moveCount[movedY][movedX] = currentMove + 1;
                }
            }
        }

        System.out.println(moveCount[N - 1][M - 1]);
    }

}
