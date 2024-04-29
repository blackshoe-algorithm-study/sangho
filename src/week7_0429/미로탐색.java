package week7_0429;

import java.io.*;
import java.util.*;

public class 미로탐색 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 그래프 입력
        int[][] graph = new int[H][W];
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                graph[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        boolean[][] visited = new boolean[H][W];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        int result = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int moveCnt = cur.moveCnt;

            // 도착한 경우
            if (x == H - 1 && y == W - 1) {
                result = moveCnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, moveCnt + 1));
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int x;
        int y;
        int moveCnt;

        Node(int x, int y, int moveCnt) {
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
        }
    }
}