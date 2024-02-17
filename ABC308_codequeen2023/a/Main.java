package ABC308_codequeen2023.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] s = new int[8];
        for (int i = 0; i < 8; i++) {
            s[i] = scanner.nextInt();
        }
        scanner.close();

        String answer = "Yes";
        for (int i = 0; i < 8; i++) {
            if (s[i] < 100 || s[i] > 675 || s[i] % 25 != 0) {
                answer = "No";
                break;
            }
            if (i > 0 && s[i] < s[i-1]) {
                answer = "No";
                break;
            }
        }
        System.out.println(answer);
    }
}
