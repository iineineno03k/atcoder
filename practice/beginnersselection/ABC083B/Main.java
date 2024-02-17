package practice.beginnersselection.ABC083B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());

        int total = 0;
        for (int i = 1; i <= n; i++) {
            int digitSum = calcDigitSum(i);
            if (digitSum >= a && digitSum <= b) {
                total += i;
            }
        }

        System.out.println(total);
        sc.close();
    }

    private static int calcDigitSum(int i) {
        int digitSum = 0;
        while (i > 0) {
            digitSum += i % 10;
            i /= 10;
        }
        return digitSum;
    }
}
