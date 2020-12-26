import java.util.*;
class FreezingDrinks {
    public static int n, m =0;
    public static int[][] arr;

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       m = sc.nextInt();
       arr= new int[n][m];
       sc.nextLine();
       int count = 0;
        
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

          for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count); 
    }

    
    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }
        if (arr[x][y] == 0) {
            arr[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

}