package a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String P = sc.nextLine();

        int L = sc.nextInt();

        if (P.length() >= L) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}