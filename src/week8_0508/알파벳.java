package week8_0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static Character[][] graph;
    private static boolean[] check = new boolean[92];
    private static int N;
    private static int M;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new Character[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = row.charAt(j);
            }
        }

        answer = 0;
        check[(int) graph[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            int nextAlpha = (int) graph[nx][ny];
            if (!check[nextAlpha]) {
                check[nextAlpha] = true;
                dfs(nx, ny, cnt + 1);
                check[nextAlpha] = false;
            }
        }
    }
}