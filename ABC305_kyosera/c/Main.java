package ABC305_kyosera.c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int W = scanner.nextInt();
        scanner.nextLine();

        String[] grid = new String[H];
        for (int i = 0; i < H; i++) {
            grid[i] = scanner.nextLine();
        }

        int top = -1, bottom = -1, left = -1, right = -1;

        // Find the rectangle
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (grid[i].charAt(j) == '#') {
                    if (top == -1) top = i;
                    bottom = i;
                    if (left == -1 || j < left) left = j;
                    if (right == -1 || j > right) right = j;
                }
            }
        }

        // Find the eaten cookie
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (grid[i].charAt(j) == '.') {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }
}
