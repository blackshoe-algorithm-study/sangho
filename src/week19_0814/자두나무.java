package week19_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자두나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[3][T + 1][W + 2]; // [현재 위치][시간][이동 횟수]

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                // 1번 나무에서 떨어지는 경우
                if (arr[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                }
                // 2번 나무에서 떨어지는 경우
                else if (arr[i] == 2) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]) + 1;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= W + 1; i++) {
            result = Math.max(result, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(result);
    }
}