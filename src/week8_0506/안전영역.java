package week8_0506;

import java.io.*;
import java.util.*;

public class 안전영역 {
    private static int[][] graph;
    private static boolean[][] visited;
    private static int N;
    private static int LIMIT;

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        LIMIT = 1;
        while (true) {
            visited = new boolean[N][N];
            int groupCnt = 0;
            // 가능한 안전 영역 모두 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 안전 영역++
                    if (graph[i][j] >= LIMIT && !visited[i][j]) {
                        dfs(i, j);
                        groupCnt++;
                    }
                }
            }
            if (groupCnt == 0) break;

            answer = Math.max(answer, groupCnt);
            LIMIT++;
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (graph[nx][ny] >= LIMIT && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
