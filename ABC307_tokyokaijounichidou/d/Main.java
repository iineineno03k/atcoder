package ABC307_tokyokaijounichidou.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        String S = sc.next();
        sc.close();
        // (が出て次の)が出たら二つのカウントを保存
        // （が出てその後（が出たら、二つの位置を持ち、）のペアは最新の（になる。
        // （より先に）があるとだめ。処理行わず。

        Map<Integer, List<Integer>> kakkoKumis = new HashMap<>();
        List<Integer> kakkokumi = new ArrayList<>();

        // (の要素番号リスト
        List<Integer> kakko = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '(') {
                kakko.add(i);
            }

            if (S.charAt(i) == ')') {
                if (!kakko.isEmpty()) {
                    kakkokumi.add(kakko.get(kakko.size() - 1));
                    kakkokumi.add(i);
                    kakkoKumis.put(count, kakkokumi);
                    count++;

                    kakko.remove(kakko.size() - 1);
                }
            }
        }
        int k = 0;
        for (int i = 0; i < kakkoKumis.size(); i++) {
            int start = kakkoKumis.get(i).get(0);
            int end = kakkoKumis.get(i).get(1) - k;

            S = S.substring(0, start) + S.substring(end + 1);

            k += (end - start + 1);
        }

        System.out.println(S);

    }
}
