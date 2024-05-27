package week11_0527;

import java.io.*;
import java.util.*;

public class 시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = 0;
        for (int P : people) {
            P -= B;
            result++;

            if (P > 0) {
                if (P % C == 0) {
                    result += (P / C);
                } else {
                    result += (P / C + 1);
                }
            }
        }

        System.out.println(result);
    }
}
