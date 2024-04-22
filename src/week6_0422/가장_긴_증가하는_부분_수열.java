package week6_0422;

import java.io.*;
import java.util.*;

public class 가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            int cur = arr[i];
            for (int j = i + 1; j < N; j++) {
                int next = arr[j];

                // 더 길어지는 경우에만 갱신
                if (next > cur && dp[j] <= dp[i]) {
                    dp[j] = dp[i] + 1;
                }
            }
        }

        // 최대 길이 찾기
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        System.out.println(maxLength);
    }
}