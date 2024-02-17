package ABC317_gamefreak.b;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        // ソートして連続する整数を復元
        Arrays.sort(A);
        int missingInteger = 0;
        
        for (int i = 1; i < N; i++) {
            if (A[i] - A[i - 1] > 1) {
                missingInteger = A[i] - 1;
                break;
            }
        }
        
        System.out.println(missingInteger);
    }
}
