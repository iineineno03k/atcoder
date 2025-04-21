package ABC401.b;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    String now = "logout";
    int count = 0;
    // Nの数だけsを入力
    for(int i = 0; i < N; i++) {
      String s = scanner.next();
      if(s.equals("login")) {
        now = "login";
      } else if(s.equals("logout")) {
        now = "logout";
      } else if(s.equals("private")){
        if(now.equals("logout")) {
          count++;
        }
      }
    }
    System.out.println(count);
    scanner.close();
  }
}