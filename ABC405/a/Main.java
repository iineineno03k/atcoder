package a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int X = scanner.nextInt();

        String result = "No";

        if (X == 1) {
            if (1600 <= R && R <= 2999) {
                result = "Yes";
            }
        } else if (X == 2) {
            if (1200 <= R && R <= 2399) {
                result = "Yes";
            }
        }

        System.out.println(result);
        scanner.close();
    }
}
