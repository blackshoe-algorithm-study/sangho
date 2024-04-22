package week6_0422;

import java.io.*;

public class 쉬운_계단_수 {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        // 첫 번째 자릿수 (=1의 자리)는 모두 1로 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // i는 자릿수를 의미함
        for (int i = 2; i <= N; i++) {
            // j는 i번째 자릿수의 자릿값을 의미함 (0 ~ 9)
            for (int j = 0; j < 10; j++) {


                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;
                }

                else if (j == 9) {
                    dp[i][j] = dp[i-1][8] % MOD;
                }

                else {
                    dp[i][j] = (dp[i - 1][j - 1] +  dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        int result = 0;
        for (int i = 1; i < 10; i++) {
            result += (dp[N][i] % MOD);
        }

        System.out.println(result);
    }
}