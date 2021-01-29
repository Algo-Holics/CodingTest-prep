package shortest.path;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class FutureCity {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Graph map = new Graph(N);
        for (int i = 0; i < M; i++) {
            int aCompany = sc.nextInt();
            int bCompany = sc.nextInt();

            map.addEdge(aCompany - 1, bCompany - 1);
            map.addEdge(bCompany - 1, aCompany - 1);
        }

        int X = sc.nextInt();
        int K = sc.nextInt();

        int kDistance = map.shortestDistance(0, K - 1);
        if (kDistance == -1) {
            System.out.println(kDistance);
            return;
        }

        int xDistance = map.shortestDistance(K - 1, X - 1);
        if (xDistance == -1) {
            System.out.println(xDistance);
            return;
        }

        System.out.println(kDistance + xDistance);
    }

    private static class Graph {
        private int totalNodes;
        private LinkedList<Integer> adjacencyNodes[];

        public Graph(int totalNodes) {
            this.totalNodes = totalNodes;
            adjacencyNodes = new LinkedList[totalNodes];
            for (int i = 0; i < totalNodes; ++i) {
                adjacencyNodes[i] = new LinkedList();
            }
        }

        public void addEdge(int v, int w) { adjacencyNodes[v].add(w); }

        public int shortestDistance(int start, int target) {
            int visited[] = new int[totalNodes];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[start] = 1;
            queue.add(start);

            while (queue.size() != 0) {
                start = queue.poll();
                if (start == target) {
                    return visited[target] - 1;
                }

                Iterator<Integer> i = adjacencyNodes[start].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (visited[n] == 0) {
                        visited[n] = visited[start] + 1;
                        queue.add(n);
                    }
                }
            }
            return -1;
        }
    }
}
