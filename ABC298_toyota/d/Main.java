package ABC298_toyota.d;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> S = new ArrayDeque<>();
        S.add(1);
        int Q = Integer.parseInt(sc.next());
        BigInteger MOD = new BigInteger("998244353");
        BigInteger TEN = new BigInteger("10");
        BigInteger ans = BigInteger.ONE;
        BigInteger pow = TEN;

        List<BigInteger> msgList = new ArrayList<>();

        for (int q = 0; q < Q; q++) {
            int queryType = Integer.parseInt(sc.next());

            if (queryType == 1) {
                int s = Integer.parseInt(sc.next());
                S.addLast(s);
                ans = ans.multiply(TEN).add(BigInteger.valueOf(s)).mod(MOD);
                pow = pow.multiply(TEN);
            } else if (queryType == 2) {
                BigInteger num = pow.multiply(BigInteger.valueOf(S.getFirst()));
                ans = ans.subtract(num).mod(MOD);
                S.removeFirst();
                pow = pow.divide(TEN);
            } else if (queryType == 3) {
                msgList.add(ans);
            }
        }
        sc.close();
        for (BigInteger msg : msgList) {
            System.out.println(msg);
        }
    }
}
