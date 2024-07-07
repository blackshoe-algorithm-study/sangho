package week15_0707;

import java.io.*;
import java.util.*;

public class 부분수열의합 {
    private static int[] nums;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        check = new boolean[2_000_001];
        createNumberSets(0, 0);

        int result = 0;
        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static void createNumberSets(int index, int currentSum) {
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int newSum = currentSum + nums[i];
            check[newSum] = true;
            createNumberSets(i + 1, newSum);
        }
    }
}