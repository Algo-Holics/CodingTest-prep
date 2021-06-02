package algo.graph;

import java.util.Scanner;

//p.393 Q41. 여행계획
public class Sol1 {
    static int N, M;
    static int[][] graph;
    static int[] move, parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][N+1];
        move = new int[M];
        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j<= N; j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 1){
                    union(i, j);
                }
            }
        }

        boolean flag = true;
        for (int i = 1; i < M; i++){
            int a = move[i-1];
            int b = move[i];
            if(find(a)!= find(b)){
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a > b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }

    public static int find(int v){
        if(v != parent[v]) parent[v] = find(parent[v]);
        return parent[v];
    }
}

/*
[TC]
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 5

[key point]
여행 계획(move)가 모두 같은 집합에 있으면 (= 부모노드가 동일하면) 가능.
*/