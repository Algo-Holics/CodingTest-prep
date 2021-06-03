package algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sol4_1 {
    static int n;
    static int[] parent;
    static List<Edge> edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        parent = new int[n + 1];

        edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        List<Pos> xList = new ArrayList<>();
        List<Pos> yList = new ArrayList<>();
        List<Pos> zList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            xList.add(new Pos(sc.nextInt(), i));
            yList.add(new Pos(sc.nextInt(), i));
            zList.add(new Pos(sc.nextInt(), i));
        }

        Collections.sort(xList);
        Collections.sort(yList);
        Collections.sort(zList);

        for (int i = 0; i < n-1; i++) {
            edges.add(new Edge(xList.get(i).idx, xList.get(i + 1).idx, xList.get(i + 1).num - xList.get(i).num));
            edges.add(new Edge(yList.get(i).idx, yList.get(i + 1).idx, yList.get(i + 1).num - yList.get(i).num));
            edges.add(new Edge(zList.get(i).idx, zList.get(i + 1).idx, zList.get(i + 1).num - zList.get(i).num));
        }

        Collections.sort(edges);

        int answer = 0;
        for (Edge E : edges) {
            int a = E.a;
            int b = E.b;
            int cost = E.cost;
            if(find(a)!= find(b)){
                union(a, b);
                answer+= cost;
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static int find(int v) {
        if (v != parent[v]) parent[v] = find(parent[v]);
        return parent[v];
    }
}


class Edge implements Comparable<Edge> {
    int a;
    int b;
    int cost;

    public Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Pos implements Comparable<Pos> {
    int num; //xyz
    int idx;

    public Pos(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    //xyz 좌표값의 크기별 정렬
    @Override
    public int compareTo(Pos o) {
        return this.num - o.num;
    }
}