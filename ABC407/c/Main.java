package c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        sc.close();

        int n = S.length();
        int ans = 0;
        int carry = 0;

        for (int i = n - 1; i >= 0; i--) {
            int digit = S.charAt(i) - '0';

            int currentDigit = (digit - carry % 10 + 10) % 10;

            int needB = currentDigit;
            ans += needB;
            carry += needB;

            ans += 1;
        }

        System.out.println(ans);
    }
}