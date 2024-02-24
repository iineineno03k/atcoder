package ABC342_huawei.b;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt(); // 人数
    int[] position = new int[N + 1]; // 各人がどの位置にいるかを格納する配列。1ベースインデックスで扱うため、サイズをN+1にする。
    for (int i = 1; i <= N; i++) {
      int P = scanner.nextInt(); // i番目に並んでいる人
      position[P] = i; // 人Pがi番目にいる
    }

    int Q = scanner.nextInt(); // クエリの数
    for (int i = 0; i < Q; i++) {
      int A = scanner.nextInt();
      int B = scanner.nextInt();
      // 人Aと人Bの位置を比較し、より前にいる人の番号を出力
      System.out.println(position[A] < position[B] ? A : B);
    }
  }
}
