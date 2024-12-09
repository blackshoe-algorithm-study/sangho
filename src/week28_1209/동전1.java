package week28_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];

        for (int n = 0; n < N; n++) {
            coins[n] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int coin : coins) { // 동전 순회
            for (int i = coin; i <= K; i++) { // 동전 가치부터 K까지
                dp[i] += dp[i - coin];
            }
        }

        System.out.print(dp[K]);
    }
}
