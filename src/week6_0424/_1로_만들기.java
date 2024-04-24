package week6_0424;

import java.io.*;
import java.util.*;

public class _1로_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N + 1];
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 3으로 나누어 떨어지는 경우
            if (cur % 3 == 0) {
                if (visited[cur / 3] == 0 || visited[cur / 3] > visited[cur] + 1) {
                    visited[cur / 3] = visited[cur] + 1;
                    q.offer(cur / 3);
                }
            }
            // 2로 나누어 떨어지는 경우
            if (cur % 2 == 0) {
                if (visited[cur / 2] == 0 || visited[cur / 2] > visited[cur] + 1) {
                    visited[cur / 2] = visited[cur] + 1;
                    q.offer(cur / 2);
                }
            }
            // 그 외의 경우
            if (cur > 1) {
                if (visited[cur - 1] == 0 || visited[cur - 1] > visited[cur] + 1) {
                    visited[cur - 1] = visited[cur] + 1;
                    q.offer(cur - 1);
                }
            }
        }

        System.out.println(visited[1]);
    }
}