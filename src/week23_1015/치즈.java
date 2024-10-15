package week23_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치즈 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static int[][] graph;
    private static int remainedCheeseCount;
    private static List<Node> meltedCheeses;
    private static boolean[][] isExposes;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        meltedCheeses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    remainedCheeseCount++;
                }
            }
        }

        int hour = 0;
        while (true) {
            // 남은 치즈 개수가 0인 경우 종료
            remainedCheeseCount -= meltedCheeses.size();
            if (remainedCheeseCount == 0) {
                break;
            }
            // 녹은 치즈 처리
            for (Node node : meltedCheeses) {
                graph[node.x][node.y] = 0;
            }
            // 외부 or 내부 공기 파악
            isExposes = new boolean[N][M];
            checkExposedAirs();
            // 녹을 치즈 파악
            meltedCheeses = new ArrayList<>();
            checkMeltedCheeses();
            // 시간++
            hour++;
        }

        System.out.print(hour);
    }

    // 외부 or 내부 공기 파악 메서드
    private static void checkExposedAirs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0)); // 가장 자리에는 무조건 공기이므로
        isExposes[0][0] = true;
        int x; int y; int nx; int ny;
        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.x;
            y = node.y;

            for (int i = 0; i < 4; i++) {
                nx = x + DX[i];
                ny = y + DY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (graph[nx][ny] == 0 && !isExposes[nx][ny]) {
                    isExposes[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    // 녹을 치즈 파악 메서드
    private static void checkMeltedCheeses() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (graph[i][j] == 1) {
                    int exposedAirCount = 0;
                    int nx; int ny;

                    for (int k = 0; k < 4; k++) {
                        nx = i + DX[k];
                        ny = j + DY[k];

                        if (graph[nx][ny] == 0 && isExposes[nx][ny]) {
                            exposedAirCount++;

                            if (exposedAirCount >= 2) {
                                meltedCheeses.add(new Node(i, j));
                                break;
                            }
                        }
                    }
                }
            }
        }
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
