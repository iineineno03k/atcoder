package ABC310_freee.b;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.next());
        int M = Integer.parseInt(sc.next());

        List<Integer> P = new ArrayList<>();
        List<Set<Integer>> records = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(sc.next());
            P.add(p);
            int C = Integer.parseInt(sc.next());
            Set<Integer> F = new HashSet<>();
            for (int j = 0; j < C; j++) {
                F.add(Integer.parseInt(sc.next()));
            }
            records.add(F);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && records.get(j).containsAll(records.get(i)) && (P.get(i) >= P.get(j))) {
                    if (!records.get(i).equals(records.get(j)) || P.get(i) > P.get(j)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }
}
