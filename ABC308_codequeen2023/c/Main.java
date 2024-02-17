package ABC308_codequeen2023.c;
import java.util.*;
import java.io.*;

class Player {
    long success;
    long total;
    int index;
    public Player(long success, long total, int index) {
        this.success = success;
        this.total = total;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Player[] players = new Player[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            players[i] = new Player(A, A + B, i + 1);
        }

        Arrays.sort(players, (p1, p2) -> {
            long compare1 = p1.success * p2.total;
            long compare2 = p2.success * p1.total;
            if (compare1 != compare2) {
                return Long.compare(compare2, compare1);
            } else {
                return Integer.compare(p1.index, p2.index);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player.index).append(" ");
        }
        System.out.print(sb.toString());
    }
}
