package ABC344_toyota.b;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<>();

    // 整数を読み込み、0が入力されるまでリストに追加する
    while (true) {
      int num = scanner.nextInt();
      numbers.add(num);
      if (num == 0) {
        break;
      }
    }

    // リストの内容を逆順に出力する
    for (int i = numbers.size() - 1; i >= 0; i--) {
      System.out.println(numbers.get(i));
    }

    scanner.close();
  }
}
