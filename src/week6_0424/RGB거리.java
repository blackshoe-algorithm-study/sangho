package week6_0424;

import java.io.*;
import java.util.*;

public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최솟값만을 계속 더하기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                // R을 칠하는 경우
                if (j == 0) {
                    // 이전 G or B
                    dp[i][j] += Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]);
                }
                // G를 칠하는 경우
                else if (j == 1) {
                    // 이전 R or B
                    dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]);
                }
                // B를 칠하는 경우
                else if (j == 2) {
                    // 이전 R or G
                    dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j - 2]);
                }
            }
        }

        int result = 100_001;
        for (int i = 0; i < 3; i++) {
            result = Math.min(result, dp[N - 1][i]);
        }

        System.out.println(result);
    }
}
