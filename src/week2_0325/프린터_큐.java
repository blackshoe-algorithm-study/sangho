package week2_0325;

import java.util.*;
import java.io.*;

public class 프린터_큐 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());

            StringTokenizer nums = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            PriorityQueue<Integer> ranks = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙으로 생성

            // 큐, 최대 힙에 숫자를 넣어줌
            for (int i = 0; i < len; i++) {
                int num = Integer.parseInt(nums.nextToken());
                q.offer(num);
                ranks.offer(num);
            }

            int rank = 1;
            while (!q.isEmpty() && !ranks.isEmpty()) {
                // 정답을 찾을 때까지 반복
                int num = q.poll();

                if (num == ranks.peek()) {
                    // 가장 중요도가 높은 문서인 경우
                    if (id == 0) {
                        // 정답을 찾은 경우
                        System.out.println(rank);
                        break;
                    }
                    // 우선순위 큐에서도 제거
                    ranks.poll();
                    rank++;
                }

                // 다시 맨 뒤에 삽입
                q.offer(num);

                // id값 갱신
                id--;
                if (id < 0) {
                    // 맨 뒤로 이동하는 경우
                    id = q.size() - 1;
                }
            }
        }
    }
}
