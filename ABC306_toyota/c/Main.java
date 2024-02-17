package ABC306_toyota.c;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[3 * N];
        for (int i = 0; i < 3 * N; i++) {
            A[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] count = new int[N + 1];
        for (int i = 0; i < 3 * N; i++) {
            count[A[i]]++;
            if (count[A[i]] == 2) {
                map.put(A[i], i + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        StringBuilder output = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : list) {
            output.append(entry.getKey()).append(" ");
            
        }

        System.out.println(output.toString().trim());
    }
}
