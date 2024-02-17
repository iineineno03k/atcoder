package ABC341_toyota.d;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();
    long M = sc.nextLong();
    long K = sc.nextLong();

    long left = 1, right = 2 * (long) 1e18;
    while (left < right) {
      long mid = left + (right - left) / 2;
      if (count(mid, N, M) < K) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    System.out.println(left);
  }

  private static long count(long x, long N, long M) {
    long lcm = lcm(N, M);
    // x までに N または M で割り切れるが、最小公倍数で割り切れない数の個数
    return x / N + x / M - 2 * (x / lcm);
  }

  private static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  private static long lcm(long a, long b) {
    return a / gcd(a, b) * b;
  }
}


