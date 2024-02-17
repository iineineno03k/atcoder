package ABC306_toyota.e;

import java.util.*;

public class Main {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int K = sc.nextInt();
         int Q = sc.nextInt();

         int[] A = new int[N + 1];
         for (int i = 1; i <= N; i++) {
             A[i] = 0;
         }

         TreeSet<Integer> B = new TreeSet<>(Comparator.reverseOrder());

         long sumB = 0;
         for (int i = 0; i < Q; i++) {
             int X = sc.nextInt();
             int Y = sc.nextInt();

             if (A[X] == 0) {
                 if (B.size() < K) {
                     B.add(Y);
                 } else if (Y < B.first()) {
                     sumB += Y - B.first();
                     B.remove(B.first());
                     B.add(Y);
                 }
             } else {
                 if (Y < A[X]) {
                     sumB += Y - A[X];
                     if (B.contains(A[X])) {
                         B.remove(A[X]);
                         B.add(Y);
                     }
                 } else {
                     if (B.contains(A[X])) {
                         B.remove(A[X]);
                         B.add(Y);
                         sumB += Y - A[X];
                     }
                 }
             }

             A[X] = Y;

             if (i >= K - 1) {
                 System.out.println(sumB + B.stream().limit(K).mapToLong(Integer::intValue).sum());
             }
         }
     }
 }
