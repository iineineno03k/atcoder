package ABC301_panasonic.d;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder S = new StringBuilder(sc.next());
        long N = sc.nextLong();
        sc.close();

        int len = S.length();

        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '?') {
                // '?'を1にした場合の値がNより大きくなるか確認。貪欲法
                S.setCharAt(i, '1');
                StringBuilder temp = new StringBuilder(S.toString().replace("?", "0"));
                if (Long.parseLong(temp.toString(), 2) > N) {
                    // Nより大きい場合は、その位置を0にする
                    S.setCharAt(i, '0');
                }
            }
        }

        // '?'が0,1で置き換えられた後の2進数が答え
        long answer = Long.parseUnsignedLong(S.toString(), 2);
        System.out.println(answer <= N ? answer : -1);
    }
}
