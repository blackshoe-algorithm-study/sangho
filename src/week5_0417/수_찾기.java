package week5_0417;

import java.io.*;
import java.util.*;

public class 수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums); // 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int start = nums[0];
        int end = nums[N - 1];

        for (int i = 0; i < M; i++) {
            int goal = Integer.parseInt(st.nextToken());

            if (goal > end || goal < start) {
                // 범위를 넘는 경우
                sb.append(0).append('\n');
                continue;
            }

            boolean isExist = binarySearch(nums, goal); // T or F
            if (isExist) {
                // 존재하는 경우
                sb.append(1).append('\n');
            } else {
                // 존재하지 않는 경우
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static boolean binarySearch(int[] nums, int goal) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            int n = nums[mid];

            if (n == goal) {
                return true;
            }

            if (n > goal) {
                high = mid - 1;
            } else if (n < goal) {
                low = mid + 1;
            }
        }

        return false;
    }
}