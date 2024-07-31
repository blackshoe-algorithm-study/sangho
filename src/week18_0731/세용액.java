package week18_0731;

import java.io.*;
import java.util.*;

public class 세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] liquids = new long[N];
        for (int i = 0; i < N; i++) {
            liquids[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(liquids);
        long[] result = findThreeLiquids(liquids, N);
        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        for (long n : result) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    private static long[] findThreeLiquids(long[] liquids, int N) {
        long minSum = Long.MAX_VALUE;
        long[] result = new long[3];
        for (int k = 0; k < N; k++) {
            long fixLiquid = liquids[k];

            int left = 0;
            int right = N - 1;
            while (left < right) {
                if (left == k) {
                    left++;
                    continue;
                }
                if (right == k) {
                    right--;
                    continue;
                }

                long sum = fixLiquid + liquids[left] + liquids[right];
                if (minSum > Math.abs(sum)) {
                    minSum = Math.abs(sum);
                    result[0] = fixLiquid;
                    result[1] = liquids[left];
                    result[2] = liquids[right];
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}