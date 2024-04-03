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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N.length(); i++) {
            Character c = N.charAt(i);

            if (!Character.isDigit(c)) {
                sb.append(c - 55);
            } else {
                sb.append(c);
            }
        }

        String num = sb.toString();

        int result = Integer.parseInt(num, B);

        System.out.println(result);
    }
}