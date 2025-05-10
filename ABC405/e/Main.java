package e;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        // 標準入力から読み込み
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt(); // リンゴの個数
        int B = scanner.nextInt(); // オレンジの個数
        int C = scanner.nextInt(); // バナナの個数
        int D = scanner.nextInt(); // ブドウの個数
        scanner.close();

        long answer = 0;

        // 一番左にあるブドウより左にi個のバナナがある場合を全て足し合わせる
        for (int i = 0; i <= C; i++) {
            // 左側 (A+B+i)C(B): A個のリンゴ、B個のオレンジ、i個のバナナの並べ方
            long leftCombination = combination(A + B + i, B, MOD);

            // 右側 (D-1+C-i)C(D-1): (C-i)個のバナナと(D-1)個のブドウの並べ方
            long rightCombination = combination(D - 1 + C - i, D - 1, MOD);

            // 左側と右側の並べ方を掛け合わせて合計に加える
            long ways = multiplyMod(leftCombination, rightCombination, MOD);
            answer = (answer + ways) % MOD;
        }

        System.out.println(answer);
    }

    // 二項係数 nCk を計算
    private static long combination(int n, int k, int mod) {
        if (k < 0 || k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;

        long numerator = 1; // 分子
        long denominator = 1; // 分母

        // min(k, n-k)を使って計算量を減らす
        k = Math.min(k, n - k);

        for (int i = 0; i < k; i++) {
            numerator = multiplyMod(numerator, n - i, mod);
            denominator = multiplyMod(denominator, i + 1, mod);
        }

        // 結果 = numerator / denominator (mod MOD)
        return multiplyMod(numerator, modInverse(denominator, mod), mod);
    }

    // modにおける乗算
    private static long multiplyMod(long a, long b, int mod) {
        return ((a % mod) * (b % mod)) % mod;
    }

    // フェルマーの小定理を使用した逆元計算
    private static long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }

    // 冪剰余計算（a^b mod m）
    private static long modPow(long base, int exponent, int mod) {
        if (exponent == 0)
            return 1;

        long half = modPow(base, exponent / 2, mod);
        long result = multiplyMod(half, half, mod);

        if (exponent % 2 == 1) {
            result = multiplyMod(result, base, mod);
        }

        return result;
    }
}