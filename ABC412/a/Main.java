package ABC412.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            if (B > A) {
                count++;
            }
        }
        
        System.out.println(count);

        sc.close();
    }
} 