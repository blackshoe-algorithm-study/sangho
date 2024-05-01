package week7_0501;

import java.io.*;
import java.util.*;

public class 벽부수고_이동하기 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()); // 가로
        int W = Integer.parseInt(st.nextToken()); // 세로

        int[][] graph = new int[H][W];
        boolean[][][] visited = new boolean[H][W][2];

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                int n = line.charAt(j) - '0';
                graph[i][j] = n;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 1));
        visited[0][0][1] = true;
        int result = -1;

        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int chance = node.chance;
            int cnt = node.cnt;

            if (x == H - 1 && y == W - 1) {
                result = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                // 일반적으로 이동 가능한 경우
                if (!visited[nx][ny][chance] && graph[nx][ny] == 0) {
                    visited[nx][ny][chance] = true;
                    q.offer(new Node(nx, ny, chance, cnt + 1));
                }
                // 벽을 부수고 이동 가능한 경우
                else if (!visited[nx][ny][0] && chance == 1 && graph[nx][ny] == 1) {
                    visited[nx][ny][0] = true;
                    q.offer(new Node(nx, ny, 0, cnt + 1));
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int x;
        int y;
        int chance;
        int cnt;

        Node(int x, int y, int chance, int cnt) {
            this.x = x;
            this.y = y;
            this.chance = chance;
            this.cnt = cnt;
        }
    }
}