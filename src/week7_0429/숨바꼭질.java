package week7_0429;

import java.io.*;
import java.util.*;

public class 숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        boolean[] visited = new boolean[100_001];
        int[] moveNums = new int[3];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        int result = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.n;
            int moveCnt = node.moveCnt;

            // 동생을 찾은 경우
            if (cur == K) {
                result = moveCnt;
                break;
            }

            moveNums[0] = cur * 2; // 순간이동을 최우선으로
            moveNums[1] = cur - 1;
            moveNums[2] = cur + 1;

            for (int next : moveNums) {
                if (next < 0 || next > 100_000) continue;

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, moveCnt + 1));
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int n;
        int moveCnt;

        Node(int n, int moveCnt) {
            this.n = n;
            this.moveCnt = moveCnt;
        }
    }
}