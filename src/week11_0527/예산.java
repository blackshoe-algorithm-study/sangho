package week11_0527;

import java.io.*;
import java.util.*;

public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] needs = new int[N];
        int right = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            right = Math.max(right, num);
            needs[i] = num;
        }

        Arrays.sort(needs);
        int left = 1;
        int mid;
        int result = 0;
        int budget = Integer.parseInt(br.readLine());

        while (left <= right) {
            mid = (left + right) / 2;

            int sum = 0;
            for (int need : needs) {
                if (need <= mid) {
                    sum += need;
                } else {
                    sum += mid;
                }
            }

            int diff = budget - sum;
            if (diff == 0) {
                result = mid;
                break;
            } else if (diff > 0) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
