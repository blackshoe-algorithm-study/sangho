package week9_0513;

import java.io.*;
import java.util.*;

public class N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                maxQ.offer(num);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            maxQ.poll();
        }

        System.out.println(maxQ.poll());
    }
}