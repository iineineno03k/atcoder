package f;

import java.util.*;

public class Main {
    static class SegmentTree {
        private int[] tree;
        private int n;

        public SegmentTree(int size) {
            n = 1;
            while (n < size)
                n *= 2;
            tree = new int[2 * n];
        }

        public void update(int pos, int val) {
            pos += n;
            tree[pos] = Math.max(tree[pos], val);
            while (pos > 1) {
                pos /= 2;
                tree[pos] = Math.max(tree[2 * pos], tree[2 * pos + 1]);
            }
        }

        public int query(int left, int right) {
            left += n;
            right += n;
            int result = 0;

            while (left <= right) {
                if (left % 2 == 1)
                    result = Math.max(result, tree[left++]);
                if (right % 2 == 0)
                    result = Math.max(result, tree[right--]);
                left /= 2;
                right /= 2;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        int R = sc.nextInt();

        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        List<int[]> scaffolds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scaffolds.add(new int[] { heights[i], i });
        }
        scaffolds.sort((a, b) -> Integer.compare(a[0], b[0]));

        boolean[] canMove = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && heights[j] <= heights[i] - D && Math.abs(i - j) <= R) {
                    canMove[i] = true;
                    break;
                }
            }
        }

        SegmentTree st = new SegmentTree(N);
        int[] dp = new int[N];

        for (int[] scaffold : scaffolds) {
            int pos = scaffold[1];

            int leftPos = Math.max(0, pos - R);
            int rightPos = Math.min(N - 1, pos + R);

            int maxDp = st.query(leftPos, rightPos);

            if (canMove[pos]) {
                dp[pos] = maxDp + 1;
            } else {
                dp[pos] = 0;
            }

            st.update(pos, dp[pos]);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
        sc.close();
    }
}