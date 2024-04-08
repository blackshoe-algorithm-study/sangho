package week4_0408;

import java.io.*;
import java.util.*;

public class 피로도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int time = 0;
        int health = 0;
        int result = 0;
        while (time < 24) {
            if (health + A <= M) {
                health += A;
                result += B;
            } else {
                health = Math.max(0, health - C);
            }

            time++;
        }

        System.out.println(result);
    }
}
