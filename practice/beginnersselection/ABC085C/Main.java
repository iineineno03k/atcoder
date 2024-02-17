package practice.beginnersselection.ABC085C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int y = Integer.parseInt(sc.next());

        String msg = "-1 -1 -1";
        for (int i = n; i >= 0; i--) {
            for (int j = n - i; j >= 0; j--) {
                int k = n - (i + j);
                int money = i * 10000 + j * 5000 + k * 1000;
                if (money == y) {
                    msg = i + " " + j + " " + k;
                    break;
                }
            }
            if (!msg.equals("-1 -1 -1")) {
                break;
            }
        }

        System.out.println(msg);
        sc.close();
    }
}
