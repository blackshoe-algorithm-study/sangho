package week3_0403;

import java.io.*;
import java.util.*;

public class 진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        br.close();

        int temp = 1; // B진수의 몇 승인지
        int sum = 0; // 10진수의 값

        // 맨 오른쪽부터 확인
        for (int i = N.length() - 1; i >= 0; i--) {
            Character c = N.charAt(i);

            if (!Character.isDigit(c)) {
                sum += (c - 55) * temp;
            } else {
                sum += (c - '0') * temp;
            }

            temp *= B; // 1승씩 +
        }

        System.out.println(sum);
    }
}