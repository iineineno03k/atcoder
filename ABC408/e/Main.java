package e;

import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1 << 30;

    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int n = in.nextInt();
        int m = in.nextInt();

        List<Edge>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++)
            g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
        }

        Map<String, Boolean> visited = new HashMap<>();
        Deque<State> deque = new ArrayDeque<>();

        deque.addFirst(new State(1, 0));
        visited.put("1,0", true);

        int result = INF;

        while (!deque.isEmpty()) {
            State curr = deque.pollFirst();
            int u = curr.node;
            int orValue = curr.orValue;

            if (u == n) {
                result = Math.min(result, orValue);
                continue;
            }

            for (Edge e : g[u]) {
                int v = e.to;
                int newOrValue = orValue | e.w;
                String state = v + "," + newOrValue;

                if (!visited.containsKey(state)) {
                    visited.put(state, true);

                    if (newOrValue == orValue) {
                        deque.addFirst(new State(v, newOrValue));
                    } else {
                        deque.addLast(new State(v, newOrValue));
                    }
                }
            }
        }

        System.out.println(result);
    }

    static class State {
        int node, orValue;

        State(int node, int orValue) {
            this.node = node;
            this.orValue = orValue;
        }
    }

    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return ret;
        }
    }
}