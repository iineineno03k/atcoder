package practice.beginnersselection.ABC081B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class testMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(sc.next()));
        }

        int divideCount = 0;
        while (numbers.stream().allMatch(number -> number % 2 == 0)) {
            numbers = numbers.stream().map(number -> number / 2).collect(Collectors.toList());
            divideCount++;
        }

        System.out.println(divideCount);
        sc.close();
    }
}
