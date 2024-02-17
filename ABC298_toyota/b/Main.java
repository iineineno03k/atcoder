package ABC298_toyota.b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = scanner.nextInt();
            }
        }
        for (int k = 0; k < 4; k++) {
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 1 && b[i][j] == 0) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                System.out.println("Yes");
                return;
            }
            a = rotate(a);
        }
        System.out.println("No");
        
    }

    static int[][] rotate(int[][] a) {
        int n = a.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = a[i][j];
            }
        }
        return res;
    }
}
