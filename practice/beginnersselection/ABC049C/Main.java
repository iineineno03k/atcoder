package practice.beginnersselection.ABC049C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String test = s;

        String prefix1 = "dream";
        String prefix2 = "dreamer";
        String prefix3 = "erase";
        String prefix4 = "eraser";

        String t = "";
        StringBuilder builder = new StringBuilder();
        builder.append(t);

        while (true) {
            // endsWithならdreamとeraseがdreamerになる問題を避けられる。
            if (test.startsWith(prefix2)) {
                test = test.replaceFirst(prefix1, "");
                if (test.startsWith(prefix3)) {
                    builder.append(prefix1);
                    continue;
                }
                builder.append(prefix2);
                test = test.replaceFirst("er", "");
            } else if (test.startsWith(prefix4)) {
                builder.append(prefix4);
                test = test.replaceFirst(prefix4, "");
            } else if (test.startsWith(prefix1)) {
                builder.append(prefix1);
                test = test.replaceFirst(prefix1, "");
            } else if (test.startsWith(prefix3)) {
                builder.append(prefix3);
                test = test.replaceFirst(prefix3, "");
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
