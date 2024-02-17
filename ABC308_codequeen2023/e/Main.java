package ABC308_codequeen2023.e;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] count = new int[3];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            count[A[i]]++;
        }

        String S = br.readLine();
        long answer = 0;
        int mex = 0;
        int M_count = 0;
        int E_count = 0;

        for (int i = 0; i < N; i++) {
            while (mex < 3 && count[mex] > 0) {
                mex++;
            }

            if (S.charAt(i) == 'M') {
                M_count++;
            } else if (S.charAt(i) == 'E') {
                E_count += M_count;
            } else if (S.charAt(i) == 'X') {
                answer += (long)mex * E_count;
            }

            count[A[i]]--;
        }

        System.out.println(answer);
    }
}
