package d;

import java.util.*;

public class Main {

    public static String solve(String s) {
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                int j = i + 1;
                while (j < n && s.charAt(j) <= s.charAt(i)) {
                    j++;
                }
                String substring = s.substring(i, j);
                String shifted = substring.substring(1) + substring.charAt(0);
                return s.substring(0, i) + shifted + s.substring(j);
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(solve(s));
        }

        sc.close();
    }
}