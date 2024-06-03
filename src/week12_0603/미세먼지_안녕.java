package week12_0603;

import java.io.*;
import java.util.*;

public class 미세먼지_안녕 {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] graph;
    private static int R;
    private static int C;
    private static int T;
    private static Location up;
    private static Location down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        boolean isUp = true;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    if (isUp) {
                        up = new Location(i, j);
                        isUp = false;
                    } else {
                        down = new Location(i, j);
                    }
                }
                graph[i][j] = num;
            }
        }

        for (int time = 0; time < T; time++) {
            spreadDust();
            operateAirPurifier();
        }

        int dustSum = calculateDustSum();
        System.out.println(dustSum);
    }

    private static void spreadDust() {
        int[][] dusts = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] > 0) {
                    int amount = graph[i][j] / 5;
                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && graph[nx][ny] != -1) {
                            dusts[nx][ny] += amount;
                            count++;
                        }
                    }
                    dusts[i][j] += graph[i][j] - amount * count;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != -1) {
                    graph[i][j] = dusts[i][j];
                }
            }
        }
    }

    private static void operateAirPurifier() {
        // 위쪽 공기청정기 반시계방향
        for (int i = up.x - 1; i > 0; i--) graph[i][0] = graph[i - 1][0];
        for (int i = 0; i < C - 1; i++) graph[0][i] = graph[0][i + 1];
        for (int i = 0; i < up.x; i++) graph[i][C - 1] = graph[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) graph[up.x][i] = graph[up.x][i - 1];
        graph[up.x][1] = 0;

        // 아래쪽 공기청정기 시계방향
        for (int i = down.x + 1; i < R - 1; i++) graph[i][0] = graph[i + 1][0];
        for (int i = 0; i < C - 1; i++) graph[R - 1][i] = graph[R - 1][i + 1];
        for (int i = R - 1; i > down.x; i--) graph[i][C - 1] = graph[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) graph[down.x][i] = graph[down.x][i - 1];
        graph[down.x][1] = 0;
    }

    private static int calculateDustSum() {
        int dustSum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] > 0) {
                    dustSum += graph[i][j];
                }
            }
        }
        return dustSum;
    }

    static class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
