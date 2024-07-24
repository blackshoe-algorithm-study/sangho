package week17_0724;

import java.io.*;
import java.util.*;

public class 역사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dp[u][v] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (dp[i][k] != 0 && dp[k][j] != 0) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        int S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 0;
            if (dp[a][b] == 1) {
                result = -1;
            } else if (dp[b][a] == 1) {
                result = 1;
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}