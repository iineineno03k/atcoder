package ABC306_toyota.b;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < 64; i++) {
            BigInteger bit = BigInteger.valueOf(scanner.nextInt());
            result = result.add(bit.shiftLeft(i));
        }

        System.out.println(result);
    }
}
