package b;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        TreeSet<Integer> uniqueNumbers = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            uniqueNumbers.add(sc.nextInt());
        }

        System.out.println(uniqueNumbers.size());

        boolean first = true;
        for (int num : uniqueNumbers) {
            if (!first) {
                System.out.print(" ");
            }
            System.out.print(num);
            first = false;
        }
        System.out.println();

        sc.close();
    }
}