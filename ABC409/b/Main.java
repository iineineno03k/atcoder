package b;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);
        for (int i = 0; i < N / 2; i++) {
            int temp = A[i];
            A[i] = A[N - 1 - i];
            A[N - 1 - i] = temp;
        }

        int maxX = 0;
        
        for (int x = 0; x <= N; x++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] >= x) {
                    count++;
                }
            }
            
            if (count >= x) {
                maxX = x;
            }
        }

        System.out.println(maxX);
        sc.close();
    }
} 