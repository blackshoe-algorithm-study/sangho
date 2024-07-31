package week18_0731;

import java.io.*;
import java.util.*;

public class 랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lans = new long[K];
        long maxNum = 0;
        for (int i = 0; i < K; i++) {
            long num = Long.parseLong(br.readLine());
            lans[i] = num;
            maxNum = Math.max(maxNum, num);
        }

        long result = binarySearch(lans, maxNum, N);
        System.out.println(result);
    }

    private static long binarySearch(long[] lans, long maxNum, int N) {
        long left = 1;
        long right = maxNum;
        long mid;
        long result = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            int cnt = 0;
            for (long lan : lans) {
                cnt += (int) (lan / mid);
            }

            if (cnt >= N) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}