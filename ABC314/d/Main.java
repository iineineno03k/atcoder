package ABC314.d;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] S = sc.next().toCharArray();
        int Q = sc.nextInt();

        String state = "none";
        Map<Integer, Character> modifications = new HashMap<>();

        for (int i = 0; i < Q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                int x = sc.nextInt() - 1;
                char c = sc.next().charAt(0);
                S[x] = c;
                modifications.put(x, c);
            } else if (t == 2) {
                state = "lower";
                sc.nextInt(); // x_iの読み捨て
                sc.next(); // c_iの読み捨て
                modifications.clear();
            } else if (t == 3) {
                state = "upper";
                sc.nextInt(); // x_iの読み捨て
                sc.next(); // c_iの読み捨て
                modifications.clear();
            }
        }

        for (int i = 0; i < N; i++) {
            if (modifications.containsKey(i)) {
                S[i] = modifications.get(i);
            } else if (state.equals("lower")) {
                S[i] = Character.toLowerCase(S[i]);
            } else if (state.equals("upper")) {
                S[i] = Character.toUpperCase(S[i]);
            }
        }

        System.out.println(new String(S));
    }
}
