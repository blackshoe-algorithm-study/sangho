package week16_0714;

import java.io.*;
import java.util.*;

public class 주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == M) {
                result++;
                left++;
            } else if (sum > M) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result);
    }
}