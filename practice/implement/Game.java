package implement;

import java.util.Scanner;

class Game {

    private static final int[][] MOVE_DISTENCE = new int[][] {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int y = sc.nextInt();
        int x = sc.nextInt();
        int d = sc.nextInt();

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int moveTotal = 1;

        map[y][x] = 2;
        int currentDirection = d;
        while(true) {
            int nextDirection = getNextPosition(map, y, x, currentDirection);
            if (nextDirection == -1) {
                int backDirection = currentDirection + 2;
                if (backDirection > 3) {
                    backDirection -= 4;
                }

                x += MOVE_DISTENCE[backDirection][0];
                y += MOVE_DISTENCE[backDirection][1];

                if (map[y][x] == 1) {
                    break;
                }

                continue;
            }

            currentDirection = nextDirection;

            x += MOVE_DISTENCE[nextDirection][0];
            y += MOVE_DISTENCE[nextDirection][1];

            map[y][x] = 2;

            moveTotal++;
        }

        System.out.println(moveTotal);

    }

    private static final int getNextPosition (
        int[][] map,
        int currentY,
        int currentX,
        int currentDirection) {
        for (int i = 0; i < MOVE_DISTENCE.length; i++) {
            if (--currentDirection < 0) {
                currentDirection += 4;
            }

            int moveXDistence = MOVE_DISTENCE[currentDirection][0];
            int moveYDistence = MOVE_DISTENCE[currentDirection][1];
            if (map[currentY + moveYDistence][currentX + moveXDistence] == 0) {
                return currentDirection;
            }
        }
        return -1;
    }

}
