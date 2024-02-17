package ABC306_toyota.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String S = scanner.nextLine();
        StringBuilder result = new StringBuilder(2 * N);
        
        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            result.append(c).append(c);
        }
        
        System.out.println(result.toString());
    }
}
