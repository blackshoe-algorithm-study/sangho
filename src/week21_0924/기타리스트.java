package week21_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타리스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 곡의 개수
        int S = Integer.parseInt(st.nextToken());  // 시작 볼륨
        int M = Integer.parseInt(st.nextToken());  // 최대 볼륨

        int[] V = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];  // dp[i][j]는 i번째 곡에서 볼륨 j가 가능한지 여부
        dp[0][S] = true;  // 시작 볼륨

        // 가능한 볼륨 상태 전부 저장
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {  // 이전 곡에서 볼륨 j가 가능하다면
                    // 볼륨을 올리는 경우
                    if (j + V[i] <= M) {
                        dp[i][j + V[i]] = true;
                    }
                    // 볼륨을 내리는 경우
                    if (j - V[i] >= 0) {
                        dp[i][j - V[i]] = true;
                    }
                }
            }
        }

        // 마지막 곡에서 가능한 최대 볼륨 찾기
        int result = -1;
        for (int j = 0; j <= M; j++) {
            if (dp[N][j]) {
                result = j;  // 최댓값 갱신
            }
        }

        System.out.println(result);
    }
}