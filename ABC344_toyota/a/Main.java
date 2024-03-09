package ABC344_toyota.a;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 文字列Sを入力から受け取る
    String S = scanner.next();

    // 最初の'|'の位置を見つける
    int firstPipeIndex = S.indexOf('|');

    // 最後の'|'の位置を見つける
    int lastPipeIndex = S.lastIndexOf('|');

    // '|'の間と'|'自体を削除した文字列を構築
    String result = S.substring(0, firstPipeIndex) + S.substring(lastPipeIndex + 1);

    // 結果を出力
    System.out.println(result);

    scanner.close();
  }
}
