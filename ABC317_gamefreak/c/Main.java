package ABC317_gamefreak.c;
import java.io.*;
import java.util.*;

class Town {
    int id;
    List<Road> roads;

    public Town(int id) {
        this.id = id;
        this.roads = new ArrayList<>();
    }
}

class Road {
    int to;
    int length;

    public Road(int to, int length) {
        this.to = to;
        this.length = length;
    }
}

public class Main {
    static int maxTotalLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of towns
        int M = scanner.nextInt(); // Number of roads

        Town[] towns = new Town[N + 1]; // Towns are 1-indexed

        for (int i = 1; i <= N; i++) {
            towns[i] = new Town(i);
        }

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            towns[A].roads.add(new Road(B, C));
            towns[B].roads.add(new Road(A, C));
        }

        maxTotalLength = 0;
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            dfs(towns, i, 0, visited);
        }

        System.out.println(maxTotalLength);
    }

    static void dfs(Town[] towns, int currentTown, int currentLength, boolean[] visited) {
        visited[currentTown] = true;

        for (Road road : towns[currentTown].roads) {
            if (!visited[road.to]) {
                dfs(towns, road.to, currentLength + road.length, visited);
            }
        }

        maxTotalLength = Math.max(maxTotalLength, currentLength);
        visited[currentTown] = false;
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.StringTokenizer;

// class ABC305_kyosera.d.Main {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());

// int N = Integer.parseInt(st.nextToken()); // 街の数
// int M = Integer.parseInt(st.nextToken()); // 道路の数

// List<List<Edge>> graph = new ArrayList<>();
// for (int i = 0; i <= N; i++) {
// graph.add(new ArrayList<>());
// }

// for (int i = 0; i < M; i++) {
// st = new StringTokenizer(br.readLine());
// int A = Integer.parseInt(st.nextToken());
// int B = Integer.parseInt(st.nextToken());
// int C = Integer.parseInt(st.nextToken());

// graph.get(A).add(new Edge(B, C));
// graph.get(B).add(new Edge(A, C));
// }

// int maxDistance = 0;
// for (int start = 1; start <= N; start++) {
// int[] dist = new int[N + 1];
// boolean[] visited = new boolean[N + 1];

// dfs(graph, start, 0, dist, visited);

// for (int i = 1; i <= N; i++) {
// maxDistance = Math.max(maxDistance, dist[i]);
// }
// }

// System.out.println(maxDistance);
// }

// static class Edge {
// int to;
// int cost;

// public Edge(int to, int cost) {
// this.to = to;
// this.cost = cost;
// }
// }

// static void dfs(List<List<Edge>> graph, int node, int distance, int[] dist,
// boolean[] visited) {
// dist[node] = distance;
// visited[node] = true;

// for (Edge edge : graph.get(node)) {
// if (!visited[edge.to]) {
// dfs(graph, edge.to, distance + edge.cost, dist, visited);
// }
// }
// }
// }
