package ABC412.c;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            long[] S = new long[N + 1];

            for (int i = 1; i <= N; i++) {
                S[i] = Long.parseLong(input[i - 1]);
            }

            if (N == 1) {
                sb.append("-1\n");
                continue;
            }

            TreeSet<Integer> unvisited = new TreeSet<>((a, b) -> {
                int cmp = Long.compare(S[a], S[b]);
                return cmp != 0 ? cmp : Integer.compare(a, b);
            });

            for (int i = 1; i <= N; i++) {
                unvisited.add(i);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            int[] dist = new int[N + 1];
            Arrays.fill(dist, -1);

            queue.offer(1);
            dist[1] = 1;
            unvisited.remove(1);

            while (!queue.isEmpty()) {
                int u = queue.poll();

                if (u == N) {
                    break;
                }

                long maxSize = 2L * S[u];

                List<Integer> toAdd = new ArrayList<>();
                Iterator<Integer> it = unvisited.iterator();

                while (it.hasNext()) {
                    int v = it.next();
                    if (S[v] <= maxSize) {
                        toAdd.add(v);
                        it.remove();
                    } else {
                        break;
                    }
                }

                for (int v : toAdd) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }

            sb.append(dist[N]).append("\n");
        }

        System.out.print(sb.toString());
    }
}