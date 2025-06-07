package f;

import java.util.*;

public class Main {

    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py)
                return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        long[][] points = new long[3000][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextLong();
            points[i][1] = sc.nextLong();
        }

        UnionFind uf = new UnionFind(3000);
        int currentN = n;

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                long a = sc.nextLong();
                long b = sc.nextLong();
                points[currentN][0] = a;
                points[currentN][1] = b;
                currentN++;
            } else if (type == 2) {
                Set<Integer> componentSet = new HashSet<>();
                for (int j = 0; j < currentN; j++) {
                    componentSet.add(uf.find(j));
                }

                int m = componentSet.size();

                if (m == 1) {
                    System.out.println(-1);
                } else {
                    long minDist = Long.MAX_VALUE;

                    for (int j = 0; j < currentN; j++) {
                        for (int k = j + 1; k < currentN; k++) {
                            if (!uf.connected(j, k)) {
                                long dist = Math.abs(points[j][0] - points[k][0]) +
                                        Math.abs(points[j][1] - points[k][1]);
                                minDist = Math.min(minDist, dist);
                            }
                        }
                    }

                    for (int j = 0; j < currentN; j++) {
                        for (int k = j + 1; k < currentN; k++) {
                            if (!uf.connected(j, k)) {
                                long dist = Math.abs(points[j][0] - points[k][0]) +
                                        Math.abs(points[j][1] - points[k][1]);
                                if (dist == minDist) {
                                    uf.union(j, k);
                                }
                            }
                        }
                    }

                    System.out.println(minDist);
                }
            } else {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                System.out.println(uf.connected(u, v) ? "Yes" : "No");
            }
        }

        sc.close();
    }
}