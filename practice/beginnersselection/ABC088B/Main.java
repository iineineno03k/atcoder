package practice.beginnersselection.ABC088B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(sc.next());
            list.add(a);
        }

        int aliceTotal = 0;
        int bobTotal = 0;

        while (list.size() > 0) {
            int max = Collections.max(list);
            aliceTotal += max;
            list.remove(list.indexOf(max));

            if (list.size() != 0) {
                max = Collections.max(list);
                bobTotal += max;
                list.remove(list.indexOf(max));
            }
        }
        System.out.println(aliceTotal - bobTotal);
        sc.close();
    }
}
