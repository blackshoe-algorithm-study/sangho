package week9_0515;

import java.io.*;
import java.util.*;

public class 절댓값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Node> q = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 출력
            if (num == 0) {
                // q가 비어있는 경우
                if (q.isEmpty()) {
                    sb.append(0).append('\n');
                }
                // q에 Node가 있는 경우
                else if (!q.isEmpty()) {
                    int minNum = q.poll().num;
                    sb.append(minNum).append('\n');
                }
            }
            // 우선순위 큐에 삽입
            else if (num != 0) {
                int absNum = Math.abs(num);
                q.offer(new Node(num, absNum));
            }
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int num;
        int absNum;

        Node(int num, int absNum) {
            this.num = num;
            this.absNum = absNum;
        }

        @Override
        public int compareTo(Node o) {

            // 절댓값이 같으면 더 작은 수가 우선
            if (this.absNum == o.absNum) {
                return Integer.compare(this.num, o.num);
            }

            return Integer.compare(this.absNum, o.absNum);
        }
    }
}