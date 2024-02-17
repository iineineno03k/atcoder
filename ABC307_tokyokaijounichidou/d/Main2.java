package ABC307_tokyokaijounichidou.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        StringBuilder S = new StringBuilder(sc.next());
        sc.close();

        List<Integer> kakko = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '(') {
                kakko.add(i);
            }

            if (S.charAt(i) == ')' && !kakko.isEmpty()) {
                int start = kakko.get(kakko.size() - 1);
                int end = i;

                S.delete(start, end + 1);

                kakko.remove(kakko.size() - 1);
                i -= (end - start + 1); // Update i due to deletion
                N -= (end - start + 1); // Update N due to deletion
            }
        }

        System.out.println(S);
    }
}
