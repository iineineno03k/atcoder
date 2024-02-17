package ABC307_tokyokaijounichidou.c;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H_A = scanner.nextInt();
        int W_A = scanner.nextInt();
        char[][] A = new char[H_A][W_A];
        for (int i = 0; i < H_A; i++) {
            A[i] = scanner.next().toCharArray();
        }

        int H_B = scanner.nextInt();
        int W_B = scanner.nextInt();
        char[][] B = new char[H_B][W_B];
        for (int i = 0; i < H_B; i++) {
            B[i] = scanner.next().toCharArray();
        }

        int H_X = scanner.nextInt();
        int W_X = scanner.nextInt();
        char[][] X = new char[H_X][W_X];
        for (int i = 0; i < H_X; i++) {
            X[i] = scanner.next().toCharArray();
        }
        for (int shiftI = -H_A; shiftI < H_A + H_X; shiftI++) {
            for (int shiftJ = -W_A; shiftJ < W_A + W_X; shiftJ++) {
                for (int iShiftB = -H_B; iShiftB < H_B + H_X; iShiftB++) {
                    for (int jShiftB = -W_B; jShiftB < W_B + W_X; jShiftB++) {

                        char[][] C = new char[H_X][W_X];
                        boolean flg = true;

                        for (int i = 0; i < H_X; i++) {
                            for (int j = 0; j < W_X; j++) {
                                C[i][j] = '.';
                            }
                        }

                        for (int i = 0; i < H_A; i++) {
                            for (int j = 0; j < W_A; j++) {
                                if (A[i][j] == '#') {
                                    if (shiftI + i >= 0 && shiftI + i < H_X && shiftJ + j >= 0 && shiftJ + j < W_X) {
                                        C[shiftI + i][shiftJ + j] = '#';
                                    } else {
                                        flg = false;
                                    }
                                }
                            }
                        }
                        for (int i = 0; i < H_B; i++) {
                            for (int j = 0; j < W_B; j++) {
                                if (B[i][j] == '#') {
                                    if (iShiftB + i >= 0 && iShiftB + i < H_X && jShiftB + j >= 0
                                            && jShiftB + j < W_X) {
                                        C[iShiftB + i][jShiftB + j] = '#';
                                    } else {
                                        flg = false;
                                    }
                                }
                            }
                        }

                        loop: for (int i = 0; i < H_X; i++) {
                            for (int j = 0; j < W_X; j++) {
                                if (C[i][j] != X[i][j]) {
                                    flg = false;
                                    break loop;
                                }
                            }
                        }

                        if (flg) {
                            System.out.println("Yes");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("No");
    }
}
