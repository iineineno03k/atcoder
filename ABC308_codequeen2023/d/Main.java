package ABC308_codequeen2023.d;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        scanner.nextLine();
        String[] s = new String[h];
        for (int i = 0; i < h; i++) {
            s[i] = scanner.nextLine();
        }
        if (s[0].charAt(0) != 's') {
            System.out.println("No");
            return;
        }
        Map<Character, Character> next = new HashMap<>();
        next.put('s', 'n');
        next.put('n', 'u');
        next.put('u', 'k');
        next.put('k', 'e');
        next.put('e', 's');
        boolean[][] seen = new boolean[h][w];
        dfs(0, 0, s, next, seen, h, w);
        System.out.println(seen[h - 1][w - 1] ? "Yes" : "No");
    }

    private static void dfs(int i, int j, String[] s, Map<Character, Character> next, boolean[][] seen, int h, int w) {
        seen[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k]; //y軸
            int nj = j + dy[k]; //x軸
            if (ni < 0 || ni >= h || nj < 0 || nj >= w) continue;
            if (s[ni].charAt(nj) != next.get(s[i].charAt(j))) continue;
            if (seen[ni][nj]) continue; //既に行ったところかどうか。
            dfs(ni, nj, s, next, seen, h, w);
        }
    }
}
