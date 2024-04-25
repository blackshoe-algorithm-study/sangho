package week6_0424;

import java.io.*;
import java.util.*;

public class 내리막길 {
    // 상하좌우
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] board;
    private static int[][] dp;
    private static int H;
    private static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        dp = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {

        if (x == H - 1 && y == W - 1) {
            return 1; // 경로의 수 + 1
        }

        // 이미 경로가 있는 경우
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int ways = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 넘는 경우
            if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

            // 내리막길인 경우에만
            if (board[nx][ny] < board[x][y]) {
                ways += dfs(nx, ny);
            }
        }

        dp[x][y] = ways;
        return dp[x][y];
    }
}