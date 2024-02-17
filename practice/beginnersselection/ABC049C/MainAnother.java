package practice.beginnersselection.ABC049C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainAnother {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String test = s;
        String suffix1 = "dream";
        String suffix2 = "dreamer";
        String suffix3 = "erase";
        String suffix4 = "eraser";

        String t = "";
        StringBuilder builder = new StringBuilder();
        builder.append(t);

        while (true) {
            // endsWithならdreamとeraseがdreamerになる問題を避けられる。
            if (test.endsWith(suffix2)) {
                builder.insert(0, suffix2);
                test = test.substring(0, test.length() - suffix2.length());
            } else if (test.endsWith(suffix4)) {
                builder.insert(0, suffix4);
                test = test.substring(0, test.length() - suffix4.length());
            } else if (test.endsWith(suffix1)) {
                builder.insert(0, suffix1);
                test = test.substring(0, test.length() - suffix1.length());
            } else if (test.endsWith(suffix3)) {
                builder.insert(0, suffix3);
                test = test.substring(0, test.length() - suffix3.length());
            } else {
                break;
            }
        }

        if (builder.toString().equals(s)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
