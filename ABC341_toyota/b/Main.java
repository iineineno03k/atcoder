package ABC341_toyota.b;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long[] A = new long[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextLong();
    }

    long[] S = new long[N - 1];
    long[] T = new long[N - 1];
    for (int i = 0; i < N - 1; i++) {
      S[i] = sc.nextLong();
      T[i] = sc.nextLong();
    }

    // DPテーブルを使用して最適な交換を計算
    for (int i = 0; i < N - 1; i++) {
      if (A[i] >= S[i]) {
        long exchanges = A[i] / S[i];
        long currencyExchange = Math.min(exchanges * T[i], A[i] - (A[i] % S[i]));
        A[i + 1] += currencyExchange;
      }
    }

    System.out.println(A[N - 1]);
    sc.close();
  }
}



