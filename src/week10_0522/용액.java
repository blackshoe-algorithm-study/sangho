package week10_0522;

import java.io.*;
import java.util.*;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] solutions = new int[N];
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        long minDiff = 2_000_000_001;
        long[] answer = new long[2];
        while (left < right) {
            long curSum = solutions[left] + solutions[right];

            if (minDiff >= Math.abs(curSum)) {
                minDiff = Math.abs(curSum);
                answer[0] = solutions[left];
                answer[1] = solutions[right];
            }

            if (curSum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}