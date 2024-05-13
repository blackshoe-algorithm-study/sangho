package week9_0513;

import java.io.*;
import java.util.*;

public class 중앙값_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            List<Integer> answers = new ArrayList<>();

            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N / 10 + 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                boolean oddFlag = true;

                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());

                    if (minQ.size() > maxQ.size()) {
                        maxQ.offer(num);
                    } else {
                        minQ.offer(num);
                    }

                    if (!minQ.isEmpty() && !maxQ.isEmpty() && minQ.peek() < maxQ.peek()) {
                        int minNum = minQ.poll();
                        int maxNum = maxQ.poll();
                        minQ.offer(maxNum);
                        maxQ.offer(minNum);
                    }

                    // 홀수 번째 수
                    if (oddFlag) {
                        answers.add(minQ.peek());
                        oddFlag = false;
                    } else {
                        oddFlag = true;
                    }
                }
            }

            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int answer : answers) {
                sb.append(answer).append(" ");
                cnt++;

                if (cnt == 10) {
                    sb.append('\n');
                    cnt = 0;
                }
            }

            System.out.println(answers.size());
            System.out.println(sb);
        }
    }
}