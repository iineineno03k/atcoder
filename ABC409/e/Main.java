package e;

import java.util.*;

public class Main {

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Edge>[] graph;
    static long[] x;
    static long totalCost = 0;

    static long dfs(int v, int parent) {
        long subtreeSum = x[v];

        for (Edge edge : graph[v]) {
            if (edge.to != parent) {
                long childSum = dfs(edge.to, v);
                subtreeSum += childSum;
                totalCost += Math.abs(childSum) * edge.weight;
            }
        }

        return subtreeSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        x = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextLong();
        }

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        totalCost = 0;
        dfs(1, -1);

        System.out.println(totalCost);
        sc.close();
    }
}