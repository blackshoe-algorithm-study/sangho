package week26_1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] smallJumps = new int[N - 1];
        int[] bigJumps = new int[N - 1];
        StringTokenizer st;
        for (int n = 0; n < N - 1; n++) {
            st = new StringTokenizer(br.readLine());
            int smallJump = Integer.parseInt(st.nextToken());
            int bigJump = Integer.parseInt(st.nextToken());
            smallJumps[n] = smallJump;
            bigJumps[n] = bigJump;
        }
        int veryBigJump = Integer.parseInt(br.readLine());

        // Chance(매우 큰 점프) 사용 여부에 따라 나뉨
        int[][] dp = new int[N][2];
        for (int i = 1; i < N; i++) {
            int afterSmallJumpAndHasChance = dp[i - 1][0] + smallJumps[i - 1];
            int afterSmallJumpAndNotHasChance = dp[i - 1][1] + smallJumps[i - 1];

            int afterBigJumpAndHasChance = 5_001;
            int afterBigJumpAndNotHasChance = 5_001;
            if (i >= 2) {
                afterBigJumpAndHasChance = dp[i - 2][0] + bigJumps[i - 2];
                afterBigJumpAndNotHasChance = dp[i - 2][1] + bigJumps[i - 2];
            }

            int afterVeryBigJump = 5_001;
            if (i >= 3) {
                afterVeryBigJump = dp[i - 3][0] + veryBigJump;
            }

            // Chance 있음
            dp[i][0] = Math.min(afterSmallJumpAndHasChance, afterBigJumpAndHasChance);
            // Chance 없음
            dp[i][1] = Math.min(Math.min(afterSmallJumpAndNotHasChance, afterBigJumpAndNotHasChance), afterVeryBigJump);
        }

        int finalMinEnergy = Math.min(dp[N - 1][0], dp[N - 1][1]);
        System.out.print(finalMinEnergy);
    }
}
