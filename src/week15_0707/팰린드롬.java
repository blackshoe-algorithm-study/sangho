package week15_0707;

import java.io.*;
import java.util.*;

public class 팰린드롬 {
    private static int[] nums;
    private static boolean[][] dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        dp = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        createPalindrome();

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (check(start, end)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void createPalindrome() {
        for (int len = 0; len < N; len++) {
            for (int i = 1; i <= N - len; i++) {
                int start = i;
                int end = i + len;

                if (start == end) {
                    dp[start][end] = true;
                    continue;
                }

                if (isPalindrome(start, end)) {
                    dp[start][end] = true;
                }
            }
        }
    }

    private static boolean isPalindrome(int start, int end) {
        // 양 끝이 같은 경우
        if (nums[start] == nums[end]) {
            // 두글자인 경우
            if (start + 1 == end) {
                return true;
            }
            // 중간이 팰린드롬인 경우
            else return dp[start + 1][end - 1];
        }
        return false;
    }

    private static boolean check(int start, int end) {
        return dp[start][end];
    }
}
