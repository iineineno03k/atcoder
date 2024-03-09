package ABC344_toyota.c;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = scanner.nextInt();
    }

    int M = scanner.nextInt();
    int[] B = new int[M];
    for (int i = 0; i < M; i++) {
      B[i] = scanner.nextInt();
    }

    int L = scanner.nextInt();
    int[] C = new int[L];
    for (int i = 0; i < L; i++) {
      C[i] = scanner.nextInt();
    }

    // A と B の全ての可能な和の組み合わせを計算し、セットに保存する
    Set<Integer> ABsums = new HashSet<>();
    for (int a : A) {
      for (int b : B) {
        ABsums.add(a + b);
      }
    }

    // クエリ数 Q の入力とクエリの処理
    int Q = scanner.nextInt();
    for (int i = 0; i < Q; i++) {
      int X = scanner.nextInt();
      boolean canMakeSum = false;
      // C の各要素について、X_i - c が ABsums に含まれるかをチェック
      for (int c : C) {
        if (ABsums.contains(X - c)) {
          canMakeSum = true;
          break;
        }
      }
      System.out.println(canMakeSum ? "Yes" : "No");
    }

    scanner.close();
  }
}
