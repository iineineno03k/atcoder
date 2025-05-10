package d;

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
        
        /*
         * 条件を整理：
         * 1. リンゴはバナナより左側に配置
         * 2. リンゴはブドウより左側に配置
         * 3. オレンジはブドウより左側に配置
         */
        
        // トポロジカル順序の考え方を使って解く
        // 条件から、果物間には以下の制約がある：
        // リンゴ → バナナ
        // リンゴ → ブドウ
        // オレンジ → ブドウ
        
        // この制約を満たすトポロジカル順序は以下の5種類：
        // 1. リンゴ → オレンジ → バナナ → ブドウ
        // 2. リンゴ → バナナ → オレンジ → ブドウ
        // 3. オレンジ → リンゴ → バナナ → ブドウ
        // 4. リンゴ → オレンジ → ブドウ → バナナ
        // 5. オレンジ → リンゴ → ブドウ → バナナ
        
        long answer = 0;
        
        // ケース1: リンゴ → オレンジ → バナナ → ブドウ
        answer = addMod(answer, countArrangements(A, B, C, D, MOD), MOD);
        
        // ケース2: リンゴ → バナナ → オレンジ → ブドウ
        answer = addMod(answer, countArrangements(A, C, B, D, MOD), MOD);
        
        // ケース3: オレンジ → リンゴ → バナナ → ブドウ
        answer = addMod(answer, countArrangements(B, A, C, D, MOD), MOD);
        
        // ケース4: リンゴ → オレンジ → ブドウ → バナナ
        answer = addMod(answer, countArrangements(A, B, D, C, MOD), MOD);
        
        // ケース5: オレンジ → リンゴ → ブドウ → バナナ
        answer = addMod(answer, countArrangements(B, A, D, C, MOD), MOD);
        
        System.out.println(answer);
    }
    
    // 指定された順序での配置の数を計算
    private static long countArrangements(int first, int second, int third, int fourth, int mod) {
        // first→second→third→fourthの順に並べる場合の数
        // 計算式: (first+second+third+fourth)! / (first! * second! * third! * fourth!)
        int total = first + second + third + fourth;
        
        long numerator = factorial(total, mod);
        
        long denominator = factorial(first, mod);
        denominator = multiplyMod(denominator, factorial(second, mod), mod);
        denominator = multiplyMod(denominator, factorial(third, mod), mod);
        denominator = multiplyMod(denominator, factorial(fourth, mod), mod);
        
        long denominatorInverse = modInverse(denominator, mod);
        
        return multiplyMod(numerator, denominatorInverse, mod);
    }
    
    // modにおける加算
    private static long addMod(long a, long b, int mod) {
        return (a + b) % mod;
    }
    
    // modにおける階乗を計算
    private static long factorial(int n, int mod) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = multiplyMod(result, i, mod);
        }
        return result;
    }
    
    // modにおける乗算
    private static long multiplyMod(long a, long b, int mod) {
        return ((a % mod) * (b % mod)) % mod;
    }
    
    // フェルマーの小定理を使用した逆元計算（MODが素数の場合のみ有効）
    private static long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }
    
    // 冪剰余計算（a^b mod m）を高速に計算
    private static long modPow(long base, int exponent, int mod) {
        if (exponent == 0) return 1;
        
        long half = modPow(base, exponent / 2, mod);
        long result = multiplyMod(half, half, mod);
        
        if (exponent % 2 == 1) {
            result = multiplyMod(result, base, mod);
        }
        
        return result;
    }
}