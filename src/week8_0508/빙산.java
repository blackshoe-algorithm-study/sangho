package week8_0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 빙산 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static int[][] graph;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static List<Ice> ices;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int year = 0;
        while (true) {
            visited = new boolean[N][M];
            ices = new ArrayList<>();
            int groupCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && graph[i][j] > 0) {
                        dfs(i, j);
                        groupCnt++;
                    }
                }
            }

            // 그룹이 2개 이상으로 나누어진 경우
            if (groupCnt >= 2) {
                answer = year;
                break;
            }
            // 빙산이 다 녹을 때까지 분리되지 않은 경우
            if (groupCnt == 0) break;

            // 근접한 바닷물의 개수만큼 녹여줌
            for (Ice ice : ices) {
                // 0 밑으로 내려가지 않도록
                graph[ice.x][ice.y] = Math.max(graph[ice.x][ice.y] - ice.nearCnt, 0);
            }

            year++;
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int nearCnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (!visited[nx][ny]) {
                if (graph[nx][ny] > 0) {
                    dfs(nx, ny);
                }
                // 근접한 바닷물++
                else if (graph[nx][ny] == 0) {
                    nearCnt++;
                }
            }
        }

        ices.add(new Ice(x, y, nearCnt)); // 근접한 바닷물의 개수 정보 추가
    }

    static class Ice{
        int x;
        int y;
        int nearCnt;

        Ice(int x, int y, int nearCnt) {
            this.x = x;
            this.y = y;
            this.nearCnt = nearCnt;
        }
    }
}