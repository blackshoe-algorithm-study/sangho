package week19_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는수 {
    private static List<Long> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();

        long result;
        if (N <= 10) {
            result = N;
        } else if (N > 1022) {
            result = -1;
        } else {
            for (int i = 0; i < 10; i++) {
                bp(i, 1);
            }
            Collections.sort(nums);
            result = nums.get(N);
        }

        System.out.println(result);
    }

    private static void bp(long num, int idx) {
        // 10 자리수가 넘지 않도록
        if (idx > 10) {
            return;
        }
        nums.add(num);
        for (int i = 0; i < num % 10; i++) {
            bp(num * 10 + i, idx + 1);
        }
    }
}