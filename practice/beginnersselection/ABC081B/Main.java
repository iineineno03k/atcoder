package practice.beginnersselection.ABC081B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.next()));
        }

        while (true) {
            if (check(list)) {
                count++;
                list = list.stream()
                        .map(number -> number / 2)
                        .collect(Collectors.toList());
            } else {
                break;
            }
        }
        System.out.println(count);

        sc.close();
    }

    private static boolean check(List<Integer> list) {
        for (int num : list) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}