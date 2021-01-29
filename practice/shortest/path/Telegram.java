package shortest.path;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Telegram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();

        Graph map = new Graph(N);
        for (int i = 0; i < M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int distance = sc.nextInt();

            map.addEdge(X - 1, new AdjacencyNode(Y - 1, distance));
        }

        Result result = map.shortestDistance(C - 1);
        System.out.print( result.getDeliveredCity() + " " + result.getDeliveredTime());
    }

    private static class Graph {
        private int totalNodes;
        private PriorityQueue<AdjacencyNode> adjacencyNodes[];

        public Graph(int totalNodes) {
            this.totalNodes = totalNodes;
            adjacencyNodes = new PriorityQueue[totalNodes];
            for (int i = 0; i < totalNodes; ++i) {
                adjacencyNodes[i] = new PriorityQueue();
            }
        }

        public void addEdge(int v, AdjacencyNode w) { adjacencyNodes[v].add(w); }

        public Result shortestDistance(int start) {
            Result result = new Result();
            boolean visited[] = new boolean[totalNodes];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            while (queue.size() != 0) {
                start = queue.poll();

                AdjacencyNode longestAdjacencyNode = adjacencyNodes[start].peek();
                if (Objects.nonNull(longestAdjacencyNode)) {
                    result.addDeliveredTime(longestAdjacencyNode.getDistance());
                }
                Iterator<AdjacencyNode> i = adjacencyNodes[start].iterator();
                while (i.hasNext()) {
                    AdjacencyNode n = i.next();
                    if (!visited[n.getvNumber()]) {
                        visited[n.getvNumber()] = true;
                        result.addDeliveredCity();
                        queue.add(n.getvNumber());
                    }
                }
            }

            return result;
        }
    }

    private static class AdjacencyNode implements Comparable<AdjacencyNode> {
        private int vNumber;
        private int distance;

        public AdjacencyNode(int vNumber, int distance) {
            this.vNumber = vNumber;
            this.distance = distance;
        }

        public int getvNumber() {
            return vNumber;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(AdjacencyNode o) {
            return Integer.compare(o.getDistance(), this.getDistance());
        }
    }

    private static class Result {
        private int deliveredCity = 0;
        private int deliveredTime = 0;

        public int getDeliveredCity() {
            return deliveredCity;
        }

        public int getDeliveredTime() {
            return deliveredTime;
        }

        public Result addDeliveredCity() {
            ++deliveredCity;
            return this;
        }

        public Result addDeliveredTime(int deliveredTime) {
            this.deliveredTime += deliveredTime;
            return this;
        }
    }
}
