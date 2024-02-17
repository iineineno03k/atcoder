package ABC304_tokyokaijounichidou.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int w = Integer.parseInt(sa[0]);
        int h = Integer.parseInt(sa[1]);
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            sa = br.readLine().split(" ");
            p[i] = Integer.parseInt(sa[0]);
            q[i] = Integer.parseInt(sa[1]);
        }
        int na = Integer.parseInt(br.readLine());
        sa = br.readLine().split(" ");
        int[] a = new int[na];
        for (int i = 0; i < na; i++) {
            a[i] = Integer.parseInt(sa[i]);
        }
        int nb = Integer.parseInt(br.readLine());
        sa = br.readLine().split(" ");
        int[] b = new int[nb];
        for (int i = 0; i < nb; i++) {
            b[i] = Integer.parseInt(sa[i]);
        }
        br.close();

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ia = binarySearch(a, p[i]);
            int ib = binarySearch(b, q[i]);
            // いちごのある座標を一つのエリアに決める。IDという考え方。
            // JavaFXやC++ではPair<int, int>で表現可能。
            long k = ia * 100000000L + ib;
            // 座標のエリアにあるいちごの数は何個なのかをカウントする。
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        // 適当なでかい値。
        int min = 1000000007;
        int max = 0;
        for (int v : map.values()) {
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        if (map.size() != (long) (na + 1) * (nb + 1)) {
            min = 0;
        }
        System.out.println(min + " " + max);
    }

    // val以上の最小の値のインデックスを返す。valが配列の最大値より大きいなら配列の長さを返す。
    // C++のlower_boundに相当する。
    static int binarySearch(int[] array, int val) {
        int ok = array.length;
        int ng = -1;
        while (Math.abs(ok - ng) > 1) {
            int mid = (ok + ng) / 2;
            if (array[mid] >= val) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
    }
}

// W=7 H=6
// N=5
// p={6,3,4,1,6}
// q={1,1,2,5,2}
// a={2,5} 7
// b={3,4} 6
