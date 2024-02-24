package ABC342_huawei.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    String S = scanner.next();
    int Q = scanner.nextInt();

    // 各文字が最終的にどの文字に変換されるかを保持するマップ
    Map<Character, Character> charMap = new HashMap<>();
    for (char c = 'a'; c <= 'z'; c++) {
      charMap.put(c, c); // 最初は自分自身にマッピング
    }

    for (int i = 0; i < Q; i++) {
      char c = scanner.next().charAt(0); // 置き換える文字
      char d = scanner.next().charAt(0); // 置き換え後の文字

      // 既存のマッピングを更新する
      for (char key : charMap.keySet().toArray(new Character[0])) {
        if (charMap.get(key) == c) {
          charMap.put(key, d);
        }
      }
    }

    // 最終的な文字列を構築
    StringBuilder finalString = new StringBuilder();
    for (char c : S.toCharArray()) {
      finalString.append(charMap.get(c));
    }

    System.out.println(finalString.toString());
  }
}
