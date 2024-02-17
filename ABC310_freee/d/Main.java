package ABC310_freee.d;

import java.util.*;

public class Main {
    static int N, T, M;
    static int[] teamCount;
    static boolean[][] conflict;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        M = sc.nextInt();

        conflict = new boolean[N][N];
        for (int i = 0; i < N; i++) {
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            conflict[a][b] = true;
            conflict[b][a] = true;
        }
        teamCount = new int[T];
        ans = 0;
        divideTeams(0);
        System.out.println(ans);
    }

    static void divideTeams(int player) {
        if (player == N) {
            for (int team : teamCount) {
                if (team == 0) return;
            }
            ans++;
            return;
        }

        for (int team = 0; team < T; team++) {
            boolean conflictExists = false;
            for (int previousPlayer = 0; previousPlayer < player; previousPlayer++) {
                if (conflict[player][previousPlayer] && teamCount[team] > 0) {
                    conflictExists = true;
                    break;
                }
            }
            if (!conflictExists) {
                teamCount[team]++;
                divideTeams(player + 1);
                teamCount[team]--;
            }
        }
    }
}
