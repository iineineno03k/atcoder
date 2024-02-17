package practice.beginnersselection.ABC085B;

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
            int d = Integer.parseInt(sc.next());
            list.add(d);
        }

        int count = 0;

        while (list.size() > 0) {

            int max = Collections.max(list);
            count++;
            list.remove(list.indexOf(max));
            if (list.size() != 0) {
                while (true) {
                    if (list.size() == 0) {
                        break;
                    }
                    int secondMax = Collections.max(list);
                    if (max != secondMax) {
                        break;
                    }
                    list.remove(list.indexOf(secondMax));
                }
            }
        }

        System.out.println(count);
        sc.close();

    }
}
