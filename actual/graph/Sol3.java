package algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//p.397 Q.43 어두운 길
public class Sol3 {
    static int N, M, total;
    static int[] parent;
    static List<Edges3> edges;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   //집
        M = sc.nextInt();   //도로

        total = 0;                  //천제 금액 초기화
        edges = new ArrayList<>();  //다리 초기화
        parent = new int[N];        //0 ~ N-1 집 초기화
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            edges.add(new Edges3(a, b, cost));
            edges.add(new Edges3(b, a, cost));
            total+= cost;
        }

        Collections.sort(edges);

        for(int i = 0; i < edges.size(); i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();
            if(find(a)!= find(b)){
                union(a, b);
                total-=cost;
            }
        }

        System.out.println(total);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a>b){
            parent[a] = b;
        }else {
            parent[b] = a;
        }
    }
    public static int find(int v){
        if(v != parent[v]) parent[v] = find(parent[v]);
        return parent[v];
    }
}

class Edges3 implements Comparable <Edges3>{
    int a;
    int b;
    int cost;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCost() {
        return cost;
    }

    Edges3(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edges3 o) {
        return Integer.compare(this.cost, o.cost);
    }
}

// 모든 가로등을 합친 전체 예산 (total) 값을 구한다.
// 간선 순으로 정렬을 한 다음, 연결이 안되어있던 집들을 연결하면서 연결시 필요한 도로의 cost 를 전체예산에서 제외한다. (예산을 사용한거라생각)
// 절약한 금액을 구하는거니까 예산에서 사용한 금액을 제외하고 남은 금액을 출력했다. (total)