package week24_1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {
    private static int[][] board;
    private static int whiteColorCount;
    private static int blueColorCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        whiteColorCount = 0;
        blueColorCount = 0;
        divideAndConquer(N, 0, 0);

        System.out.println(whiteColorCount);
        System.out.println(blueColorCount);
    }

    private static void divideAndConquer(int N, int x, int y) {
        int startColor = board[x][y];

        for (int i = x; i < N + x; i++) {
            for (int j = y; j < N + y; j++) {
                if (startColor != board[i][j]) {
                    int interval = N / 2;
                    divideAndConquer(interval, x, y);
                    divideAndConquer(interval, x + interval, y);
                    divideAndConquer(interval, x, y + interval);
                    divideAndConquer(interval, x + interval, y + interval);
                    return;
                }
            }
        }

        if (startColor == 0) {
            whiteColorCount++;
        } else {
            blueColorCount++;
        }
    }
}