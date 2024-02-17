package ABC298_toyota.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int Q = N;
        Q = Integer.parseInt(sc.next());
        Map<Integer, Map<Integer, Integer>> boxTocard = new HashMap<>();
        Map<Integer, Set<Integer>> cardTobox = new HashMap<>();
        List<String> msgList = new ArrayList<>();

        for (int q = 0; q < Q; q++) {
            int queryType = Integer.parseInt(sc.next());

            if (queryType == 1) {
                int i = Integer.parseInt(sc.next());
                int j = Integer.parseInt(sc.next());
                insertCard(i, j, boxTocard, cardTobox);
            } else if (queryType == 2) {
                int i = Integer.parseInt(sc.next());
                String result = boxTocard.get(i).entrySet().stream()
                        .flatMap(entry -> Collections.nCopies(entry.getValue(), entry.getKey()).stream())
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                msgList.add(result);

            } else if (queryType == 3) {
                int i = Integer.parseInt(sc.next());
                String result = String.join(" ", cardTobox.get(i).stream().map(String::valueOf).toArray(String[]::new));
                msgList.add(result);
            }

        }
        sc.close();

        for (String msg : msgList) {
            System.out.println(msg);
        }
    }

    private static void insertCard(int i, int j, Map<Integer, Map<Integer, Integer>> boxTocard,
            Map<Integer, Set<Integer>> cardTobox) {
        Map<Integer, Integer> cardList = boxTocard.getOrDefault(j, new TreeMap<>());
        cardList.put(i, cardList.getOrDefault(i, 0) + 1);
        boxTocard.put(j, cardList);

        Set<Integer> boxList = cardTobox.getOrDefault(i, new TreeSet<>());
        boxList.add(j);
        cardTobox.put(i, boxList);
    }
}