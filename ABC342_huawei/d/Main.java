package ABC342_huawei.d;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    Map<Long, Integer> map = new HashMap<>();
    int zeroCount = 0; // 0の出現回数をカウント

    for (int i = 0; i < N; i++) {
      long A = scanner.nextLong();
      if (A == 0) {
        zeroCount++; // 0が出現した場合、カウントを1増やす
      } else {
        long key = minMultiplierForSquare(A);
        map.put(key, map.getOrDefault(key, 0) + 1);
      }
    }

    long count = 0;
    for (int value : map.values()) {
      count += (long) value * (value - 1) / 2; // 各キーについての組み合わせ数を計算
    }
    if (zeroCount > 0) {
      count += (long) zeroCount * N - (long) zeroCount * (zeroCount + 1) / 2; // 0とそれ以外の数の組み合わせを加算
    }

    System.out.println(count);
  }

  private static long minMultiplierForSquare(long A) {
    long multiplier = 1;
    for (int i = 2; i * i <= A; i++) {
      int count = 0;
      while (A % i == 0) {
        A /= i;
        count++;
      }
      if (count % 2 != 0) multiplier *= i;
    }
    if (A > 1) multiplier *= A;
    return multiplier;
  }
}

