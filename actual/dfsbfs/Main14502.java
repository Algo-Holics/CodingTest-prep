package algo.dfsbfs;

import java.util.Arrays;
import java.util.Scanner;

public class Main14502 {
    public static final int BLANK = 0;
    public static final int WALL = 1;
    public static final int VIRUS = 2;
    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};

    public static int n, m;
    public static int[][] matrix;
    public static int[][] temp;

    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];
        temp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int count){
        //2. 벽의 갯수가 3개가 된 경우
        if(count == 3){
            //2-1. 임시 배열에 matrix 를 복사해두고 (깊은복사 해야됨!)
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    temp[i][j] = matrix[i][j];
                }
            }

            //2-2. 복사해둔 배열을 돌면서 바이러스가 있으면 퍼트려준다.
            for(int i = 0; i < n; i ++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == VIRUS) {
                        bfs(i, j);
                    }
                }
            }
            answer = Math.max(answer, safeCount());
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //1. 빈 공간인 경우 벽을 세워보고 벽의 갯수를 증가 시켜 dfs 를 돌려본다.
                if(matrix[i][j] == BLANK){
                    matrix[i][j] = WALL;
                    count += 1;
                    dfs(count);
                    count -=1;
                    matrix[i][j] = BLANK;
                }
            }
        }
    }

    public static void bfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //2- 3 bfs 돌면서 바이러스 퍼뜨리기
            if(0<= nx && nx<n && 0<= ny && ny<m){
                if(temp[nx][ny] == BLANK){
                    temp[nx][ny] = VIRUS;
                    bfs(nx, ny);
                }
            }
        }
    }

    //3. safe zone count
    public static  int safeCount(){
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(temp[i][j] == BLANK){
                  count++;
                }
            }
        }
        return count;
    }
}
