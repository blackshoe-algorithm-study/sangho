package week7_0429;

import java.io.*;
import java.util.*;

public class 토마토 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] graph = new int[H][W];
        boolean[][] visited = new boolean[H][W];
        Queue<Node> q = new LinkedList<>();
        int needCnt = 0;

        // 그래프 입력
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 익어야 하는 토마토 개수++
                if (graph[i][j] == 0) needCnt++;
                // 기존 토마토
                else if (graph[i][j] == 1) {
                    q.offer(new Node(i, j, 0));
                }
            }
        }

        // 결과 초기값 설정
        int result;
        if (needCnt == 0) {
            // 이미 모든 토마토가 익어있는 상태
            result = 0;
        } else {
            result = -1;
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int day = cur.day;

            if (needCnt == 0) {
                result = day;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (!visited[nx][ny] && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    needCnt--; // 익어야 하는 토마토 개수--
                    q.offer(new Node(nx, ny, day + 1)); // 일수++
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int x;
        int y;
        int day;

        Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}