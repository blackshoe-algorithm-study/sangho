package week6_0424;

import java.io.*;
import java.util.*;

public class 내리막길 {
    // 좌, 우, 하
    static final int[] dx = {0, 0, 1};
    static final int[] dy = {-1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] board = new int[H][W];
        int[][] dp = new int[H][W];
        dp[0][0] = 1;

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 넘는 경우
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                // 내리막길인 경우에만
                if (dp[nx][ny] < dp[x][y]) {
                    dp[nx][ny] += dp[x][y];
                    q.offer(new Node(nx, ny));
                }

                /*
                else if (dp[nx][ny] > dp[x][y] && dp[nx][ny] < dp[nx][ny] + dp[x][y]) {
                    dp[nx][ny] += dp[x][y];
                } */
            }
        }

        System.out.println(dp[H - 1][W - 1]);
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
