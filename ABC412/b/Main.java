package ABC412.b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String T = sc.nextLine();

        boolean isValid = true;

        for (int i = 1; i < S.length(); i++) {
            char currentChar = S.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                char prevChar = S.charAt(i - 1);

                if (T.indexOf(prevChar) == -1) {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}