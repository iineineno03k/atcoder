package ABC312_uniquevision.c;// import java.util.*;

// public class ABC305_kyosera.d.Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int M = sc.nextInt();

//         Integer[] sellers = new Integer[N];
//         for (int i = 0; i < N; i++) {
//             sellers[i] = sc.nextInt();
//         }
//         Arrays.sort(sellers);

//         Integer[] buyers = new Integer[M];
//         for (int i = 0; i < M; i++) {
//             buyers[i] = sc.nextInt();
//         }
//         sc.close();

//         Arrays.sort(buyers, Collections.reverseOrder());

//         int sellerIdx = 0;
//         int buyerIdx = 0;
//         while (sellers[sellerIdx] < buyers[buyerIdx]) {
//             while (buyerIdx < M && sellers[sellerIdx] <= buyers[buyerIdx]) {
//                 buyerIdx++;
//             }

//             if (sellerIdx + 1 >= buyerIdx) {
//                 break;
//             } else {
//                 sellerIdx++;
//                 buyerIdx = 0;
//             }

//         }

//         if (sellerIdx == 0) {
//             System.out.println(buyers[0] + 1);
//         } else {
//             System.out.println(sellers[sellerIdx]);
//         }
//     }
// }

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        TreeMap<Integer, Integer> sellers = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int price = sc.nextInt();
            sellers.put(price, sellers.getOrDefault(price, 0) + 1);
        }

        TreeMap<Integer, Integer> buyers = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < M; i++) {
            int price = sc.nextInt();
            buyers.put(price, buyers.getOrDefault(price, 0) + 1);
        }
        sc.close();

        int answer = buyers.firstKey() + 1;
        while (!sellers.isEmpty() && !buyers.isEmpty()) {
            int sellerPrice = sellers.firstKey();
            int buyerPrice = buyers.firstKey();

            if (buyerPrice < sellerPrice) {
                break;
            }

            int sellerCount = sellers.get(sellerPrice);
            int buyerCount = buyers.get(buyerPrice);

            if (buyerCount <= sellerCount) {
                sellers.put(sellerPrice, sellerCount - buyerCount);
                if (sellers.get(sellerPrice) == 0) {
                    sellers.remove(sellerPrice);
                }
                buyers.remove(buyerPrice);
                if (!sellers.isEmpty()) {
                    answer = sellers.firstKey();
                } else {
                    answer = sellerPrice + 1;
                }
            } else {
                buyers.put(buyerPrice, buyerCount - sellerCount);
                sellers.remove(sellerPrice);
            }
        }

        System.out.println(answer);
    }
}


