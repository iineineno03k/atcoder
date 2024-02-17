package ABC307_tokyokaijounichidou.b;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = scanner.next();
            strings.add(str);
        }

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                sb.append(strings.get(i));
                sb.append(strings.get(j));
                if (sb.toString().equals(sb.reverse().toString())) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
}
