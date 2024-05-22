package week10_0522;

import java.io.*;
import java.util.*;

public class 덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] people = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i][0] = weight;
            people[i][1] = height;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int curW = people[i][0];
            int curH = people[i][1];
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                int otherW = people[j][0];
                int otherH = people[j][1];

                if (otherW > curW && otherH > curH) {
                    rank++;
                }
            }

            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}
