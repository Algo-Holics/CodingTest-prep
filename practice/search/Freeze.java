package search;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Freeze {

    private static final int[][] MOVE = new int[][] {
        {-1, 0}, {1, 0}, {0, -1},{0, 1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

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

        int totalIceCream = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == Boolean.FALSE) {
                    totalIceCream++;

                    Queue<SimpleImmutableEntry<Integer, Integer>> queue = new LinkedList<>();
                    queue.add(new SimpleImmutableEntry<>(i, j));
                    map[i][j] = Boolean.TRUE;
                    while (!queue.isEmpty()) {
                        SimpleImmutableEntry<Integer, Integer> currentPosition = queue.poll();

                        for (int z = 0; z < MOVE.length; z++) {
                            int movedY = currentPosition.getKey() + MOVE[z][0];
                            int movedX = currentPosition.getValue() + MOVE[z][1];

                            if (movedY >= 0 && movedX >= 0
                                && movedY < N && movedX < M
                                && map[movedY][movedX].equals(Boolean.FALSE)) {
                                queue.add(new SimpleImmutableEntry<>(movedY, movedX));
                                map[movedY][movedX] = Boolean.TRUE;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(totalIceCream);
    }

}
