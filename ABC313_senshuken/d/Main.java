package ABC313_senshuken.d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        
        // Create an array that contains 1 for K - 1 elements
        int[] queryIndices = new int[K];
        for (int i = 0; i < K - 1; i++) {
            queryIndices[i] = 1;
        }

        // Iterate through the array A and determine each bit uniquely
        for (int i = 0; i < N; i++) {
            // Place the target index at the last position
            queryIndices[K - 1] = i + 1;

            // Ask the query to the judge
            System.out.print("? ");
            for (int idx : queryIndices) {
                System.out.print(idx + " ");
            }
            System.out.println();
            System.out.flush();

            // Read the response from the judge
            int response = sc.nextInt();
            
            // Since K is odd, the parity of the sum will be the value of the bit at the target index
            A[i] = response;
        }

        // Print the result
        System.out.print("! ");
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.flush();
    }
}
