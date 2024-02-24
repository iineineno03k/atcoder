package ABC342_huawei.a;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    int position = findUniqueCharacterPosition(s);
    System.out.println(position);
  }

  private static int findUniqueCharacterPosition(String s) {
    // 文字とその出現回数を記録するための配列
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
    }

    // 1回しか出現していない文字を探す
    char uniqueChar = ' ';
    for (int i = 0; i < 26; i++) {
      if (count[i] == 1) {
        uniqueChar = (char) (i + 'a');
        break;
      }
    }

    // 1回しか出現していない文字の位置を返す
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == uniqueChar) {
        // 人間が読むための位置は1ベースであるため、1を足す
        return i + 1;
      }
    }

    // ここに到達することはないが、すべてのパスが値を返す必要があるためのデフォルト値
    return -1;
  }
}
