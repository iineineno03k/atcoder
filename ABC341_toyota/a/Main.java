package ABC341_toyota.a;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= N; i++) {
      sb.append("1");
      if (i < N) {
        sb.append("0");
      }
    }

    System.out.println(sb.toString());
  }
}
