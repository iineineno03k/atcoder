package a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String T = sc.next();
        String A = sc.next();

        boolean found = false;
        
        for (int i = 0; i < N; i++) {
            if (T.charAt(i) == 'o' && A.charAt(i) == 'o') {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
} 