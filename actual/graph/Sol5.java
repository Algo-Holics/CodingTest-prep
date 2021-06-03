package algo.graph;

import java.util.*;

public class Sol5 {
    static int n, m;
    static int[] inDegree;
    static boolean[][] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            n = sc.nextInt();
            inDegree = new int[n + 1];
            edges = new boolean[n + 1][n + 1];

            // 작년 순위 정보 입력
            List<Integer> grade = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                grade.add(sc.nextInt());
            }

            //i 등을 한 팀 => j 등을 한 팀 방향 표시
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    edges[grade.get(i)][grade.get(j)] = true;
                    inDegree[grade.get(j)]++;
                }
            }

            //변경된 순위 입력
            m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                // 방향 변경
                if (edges[a][b]) {
                    change(a, b);
                } else {
                    change(b, a);
                }
            }
            topologySort();
        }
    }

    // 답안에서 반복되는 내용같아서 method 로 분리
    private static void change(int x, int y) {
        edges[x][y] = false;
        edges[y][x] = true;
        inDegree[x]++;
        inDegree[y]--;
    }

    private static void topologySort() {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        boolean onlyOne = true;         //정렬 결과 1개밖에 없는지 파악
        boolean cycle = false;          //사이클 존재 유무 파악

        //노드의 개수만큼 반복
        for(int i = 0; i < n; i++){
            // 노드개수가 차기 전에 큐 사이즈가 0 이 되면 사이클이 발생한 것
            if(q.size() == 0){
                cycle = true;
                break;
            }
            // 노드 개수가 차기 전에 큐 사이즈가 2보다 크다는거는 가능한 경우의수가 더 많다는거
            if(q.size() > 1){
                onlyOne = false;
                break;
            }

            int now = q.poll();
            res.add(now);
            for(int j = 1; j <= n; j++){
                if(edges[now][j]){
                    inDegree[j]--;
                    if(inDegree[j] == 0){
                        q.add(j);
                    }
                }
            }
        }

        if(cycle){
            System.out.println("IMPOSSIBLE");
        }else if(!onlyOne){
            System.out.println("?");
        }else{
            for(int r: res){
                System.out.print(r+" ");
            }
            System.out.println();
        }

    }
}

// p.399 Q.45 최종 순위 https://www.acmicpc.net/problem/3665
// 솔직히 이번 문제는... 해당 파트에서 위상정렬 문제가 하나도 없어서 그거 아닐까 정도만 생각을 했다;; (생각나는게 없었음 ㅠㅠ)
// 그래서 답을 보고 구현을 완성했음.. 추후에 반복해서 연습해볼것

