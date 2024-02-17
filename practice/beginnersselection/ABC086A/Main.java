package practice.beginnersselection.ABC086A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 整数の入力
        int s1 = Integer.parseInt(sc.next());
        int count = 0;

        while (0 < s1) {
            if (s1 % 10 == 1) {
                count++;
            }
            s1 = s1 / 10;
        }

        System.out.println(count);
        sc.close();
    }
}
