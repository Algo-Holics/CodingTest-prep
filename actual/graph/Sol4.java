package algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//p.398 Q44 행성 터널
public class Sol4 {
    static final int XYZ = 3;
    static int N, answer;
    static int[] parent;
    static int[][] inputData;
    static List<Planet> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList<>();
        inputData = new int[N][XYZ];

        for(int i = 0; i < N; i++){
            inputData[i][0] = sc.nextInt();
            inputData[i][1] = sc.nextInt();
            inputData[i][2] = sc.nextInt();
        }

        parent = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }

        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                int cost = findMin(i, j);
                list.add(new Planet(i, j, cost));
                list.add(new Planet(j,i, cost));
            }
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            int a = list.get(i).getA();
            int b = list.get(i).getB();
            int cost = list.get(i).cost;

            if(find(a)!=find(b)){
                union(a, b);
                answer+= cost;
            }
        }

        System.out.println(answer);
    }

    public static int findMin(int a, int b){
        int xDiff = Math.abs(inputData[a][0] - inputData[b][0]);
        int yDiff = Math.abs(inputData[a][1] - inputData[b][1]);
        int zDiff = Math.abs(inputData[a][2] - inputData[b][2]);

        return Math.min(xDiff, Math.min(yDiff, zDiff));
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

class Planet implements Comparable<Planet>{
    int a;
    int b;
    int cost;

    public Planet(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Planet o) {
        return Integer.compare(this.cost, o.cost);
    }
}

/*
5
11 -15 -15
14 -5 -15
-1 -1 -5
10 -4 -1
19 -4 19
 */