package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고 {
    private static int[][] board;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int calledCnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean isFinished = false;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int calledNum =  Integer.parseInt(st.nextToken());
                calledCnt++;
                if (isBingo(calledNum)) {
                    isFinished = true;
                    break;
                }
            }
            if (isFinished) {
                result = calledCnt;
                break;
            }
        }

        System.out.println(result);
    }

    private static boolean isBingo(int calledNum) {
        int cnt = 0;

        // 가로 줄 확인
        for (int i = 0; i < 5; i++) {
            boolean isComplete = true;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == calledNum) {
                    board[i][j] = -1;
                }
                if (board[i][j] != -1) {
                    isComplete = false;
                }
            }
            if (isComplete) {
                cnt++;
            }
        }

        // 세로 줄 확인
        for (int i = 0; i < 5; i++) {
            boolean isComplete = true;
            for (int j = 0; j < 5; j++) {
                if (board[j][i] != -1) {
                    isComplete = false;
                    break;
                }
            }
            if (isComplete) {
                cnt++;
            }
        }

        // 대각선 줄 확인
        boolean isComplete = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != -1) {
                isComplete = false;
                break;
            }
        }
        if (isComplete) {
            cnt++;
        }

       isComplete = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != -1) {
                isComplete = false;
                break;
            }
        }
        if (isComplete) {
            cnt++;
        }

        return cnt >= 3;
    }
}