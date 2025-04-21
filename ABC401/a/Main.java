package ABC401.a;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int s = scanner.nextInt();

    if(s >= 200 && s <= 299) {
      System.out.println("Success");
    } else {
      System.out.println("Failure");
    }
    
    scanner.close();
  }
}