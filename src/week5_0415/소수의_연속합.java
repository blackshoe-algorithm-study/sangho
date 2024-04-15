package week5_0415;

import java.io.*;
import java.util.*;

public class 소수의_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> primeNums = createPrimeNums(N);

        int result = 0;
        int left = 0;
        int right = 0;
        int interval = 0;

        while (right < primeNums.size()) {
            interval += primeNums.get(right);

            if (interval > N) {
                // 구간 합이 N 이하가 될 때까지 반복
                while (left < right && interval > N) {
                    interval -= primeNums.get(left);
                    left++;
                }
            }

            // 경우의 수 + 1
            if (interval == N) {
                result++;
            }

            right++;
        }

        System.out.println(result);
    }

    // limit 까지의 모든 소수들을 반환하는 메서드
    private static List<Integer> createPrimeNums(int limit) {
        List<Integer> primeNums = new ArrayList<>();
        boolean[] check = new boolean[limit + 1];

        for (int i = 2; i <= (int) Math.sqrt(limit); i++) {
            int t = 2;

            while (i * t <= limit) {
                if (!check[i * t]) {
                    check[i*t] = true; // 소수가 아님
                }

                t++;
            }
        }

        for (int i = 2; i <= limit; i++) {
            // 소수만 추가
            if (!check[i]) {
                primeNums.add(i);
            }
        }

        return primeNums;
    }
}