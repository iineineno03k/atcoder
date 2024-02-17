package practice.beginnersselection.ABC085B;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainAnother {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());

        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int d = Integer.parseInt(sc.next());
            list.add(d);
        }

        int count = 0;

        while (list.size() > 0) {

            int max = Collections.max(list);
            count++;
            list.remove(max);
        }

        System.out.println(count);
        sc.close();

    }
}
