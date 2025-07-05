package ABC413.b;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] strings = new String[N];

        for (int i = 0; i < N; i++) {
            strings[i] = sc.next();
        }

        Set<String> resultSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    String concatenated = strings[i] + strings[j];
                    resultSet.add(concatenated);
                }
            }
        }

        System.out.println(resultSet.size());

        sc.close();
    }
}