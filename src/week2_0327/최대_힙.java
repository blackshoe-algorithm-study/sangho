package week2_0327;

import java.util.*;
import java.io.*;

public class 최대_힙 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) pq.offer(num);
            else {
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
        }
    }
}