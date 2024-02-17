package ABC341_toyota.e;

import java.util.Scanner;

/**
 * TLEロジック.
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();
    StringBuilder S = new StringBuilder(sc.next());

    for (int q = 0; q < Q; q++) {
      int type = sc.nextInt();
      int L = sc.nextInt() - 1; // 0-indexedに調整
      int R = sc.nextInt() - 1; // 0-indexedに調整

      if (type == 1) {
        // クエリ1: LからRの文字を反転
        for (int i = L; i <= R; i++) {
          S.setCharAt(i, S.charAt(i) == '0' ? '1' : '0');
        }
      } else if (type == 2) {
        // クエリ2: LからRの部分文字列が良い文字列か判定
        boolean isGood = true;
        for (int i = L; i < R; i++) {
          if (S.charAt(i) == S.charAt(i + 1)) {
            isGood = false;
            break;
          }
        }
        System.out.println(isGood ? "Yes" : "No");
      }
    }
  }
}

