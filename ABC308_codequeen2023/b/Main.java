package ABC308_codequeen2023.b;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        String[] colors = scanner.nextLine().split(" ");

        HashMap<String, Integer> priceList = new HashMap<>();
        String[] pricesColors = scanner.nextLine().split(" ");

        int[] prices = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < M; i++) {
            priceList.put(pricesColors[i], prices[i + 1]);
        }

        int total = 0;
        for (String color : colors) {
            total += priceList.getOrDefault(color, prices[0]);
        }

        System.out.println(total);
    }
}
