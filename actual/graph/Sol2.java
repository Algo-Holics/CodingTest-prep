package algo.graph;

import java.util.Scanner;

//p.395 Q42.탑승구
public class Sol2 {
    static int G, P;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        G = sc.nextInt();
        P = sc.nextInt();

        parent = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }
        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int g = sc.nextInt();

            //입력받은 g 의 부모노드를 찾았는데, 그 값이 0 이면 더이상 앞에 연결 가능한 게이트가 없다는 의미이므로 중지
            int gParent = find(g);
            if (gParent == 0) break;
            //찾아낸 부모노드보다 한 단계 앞의 노드랑 연결해준다.
            union(gParent, gParent - 1);
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static int find(int v) {
        if (parent[v] != v) parent[v] = find(parent[v]);
        return parent[v];
    }
}


// BOJ 유사한문제: BOJ10775 공항 (아래 링크)
// https://www.acmicpc.net/problem/10775

// 처음에 문제를 잘 이해 못했다..
// 문제에서 'i번째 비행기를 1번부터 gi (1 ≤ gi ≤ G) 번째 게이트중 하나에 영구적으로 도킹하려 한다.' 를 이해했어야했는데
// 단번에 이해하지 못했고 자고 일어나서 개운한상태로 보니까 이해를 할 수 있었음 .. (ㅠ)

// 현재 선택한 노드의 부모노드를 찾고 그 노드가 0이 아니면 아직 1~parent[gi] 중 하나의 노드랑 연결 할 수 있다는 의미였는데...
// 그렇게 계속 연결하다가 부모노드를 찾아봤더니 0이었다면 앞에 더이상 연결 가능한 게이트가 없으니까 연결을 중지하고 해당 도킹된 비행기를 출력하면 된다.