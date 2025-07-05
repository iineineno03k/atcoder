package ABC412.d;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] currentGraph = new boolean[n][n];
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            currentGraph[a][b] = true;
            currentGraph[b][a] = true;
        }

        int minOps = Integer.MAX_VALUE;
        int totalEdges = n * (n - 1) / 2;
        
        for (int mask = 0; mask < (1 << totalEdges); mask++) {
            boolean[][] targetGraph = new boolean[n][n];
            int edgeIndex = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << edgeIndex)) != 0) {
                        targetGraph[i][j] = true;
                        targetGraph[j][i] = true;
                    }
                    edgeIndex++;
                }
            }
            
            if (isValidDegree2Graph(targetGraph, n)) {
                int ops = calculateDifference(currentGraph, targetGraph, n);
                minOps = Math.min(minOps, ops);
            }
        }

        System.out.println(minOps);
        sc.close();
    }

    static boolean isValidDegree2Graph(boolean[][] graph, int n) {
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j]) {
                    degree++;
                }
            }
            if (degree != 2) {
                return false;
            }
        }
        return true;
    }

    static int calculateDifference(boolean[][] current, boolean[][] target, int n) {
        int diff = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (current[i][j] != target[i][j]) {
                    diff++;
                }
            }
        }
        return diff;
    }
}