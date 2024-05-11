package week8_0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {
    private static String[][] graph1;
    private static String[][] graph2;
    private static boolean[][] visited1;
    private static boolean[][] visited2;
    private static int N;
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph1 = new String[N][N];
        graph2 = new String[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                String color = String.valueOf(row.charAt(j));
                graph1[i][j] = color;

                // 적록색약 고려
                if (color.equals("G")) {
                    color = "R";
                }
                graph2[i][j] = color;
            }
        }

        int answer1 = 0;
        int answer2 = 0;
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 적록색약 X
                if (!visited1[i][j]) {
                    dfs1(graph1[i][j], i, j);
                    answer1++;
                }
                // 적록색약 O
                if (!visited2[i][j]) {
                    dfs2(graph2[i][j], i, j);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    // 적록색약 X
    private static void dfs1(String color, int x, int y) {
        visited1[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (!visited1[nx][ny] && graph1[nx][ny].equals(color)) {
                dfs1(color, nx, ny);
            }
        }
    }

    // 적록색약 O
    private static void dfs2(String color, int x, int y) {
        visited2[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (!visited2[nx][ny] && graph2[nx][ny].equals(color)) {
                dfs2(color, nx, ny);
            }
        }
    }
}