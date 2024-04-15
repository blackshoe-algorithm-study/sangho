package week5_0415;

import java.io.*;
import java.util.*;

public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temps = new int[N];

        for (int i = 0; i < N; i++) {
            temps[i] = Integer.parseInt(st.nextToken());
        }

        int interval = 0; // 구간 합

        // 초기 구간 합
        for (int i = 0; i < M; i++) {
            interval += temps[i];
        }

        int result = interval; // 최종 결과
        int left = 0;
        int right = M;

        while (right < N) {
            interval -= temps[left];
            interval += temps[right];

            result = Math.max(result, interval);

            left++;
            right++;
        }

        System.out.println(result);
    }
}
