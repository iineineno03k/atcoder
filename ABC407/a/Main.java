package a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        double div = (double)A / B;
        int ans = (int)Math.round(div);
        System.out.println(ans);
        
    }
}