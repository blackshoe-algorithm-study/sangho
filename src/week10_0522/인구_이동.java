package week10_0522;

import java.io.*;
import java.util.*;

public class 인구_이동 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static int N;
    private static int L;
    private static int R;
    private static int[][] countries;
    private static boolean[][] visited;
    private static List<Node> union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 초기 인구수 할당
        countries = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            visited = new boolean[N][N];
            union = new ArrayList<>();
            boolean stop = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        union = new ArrayList<>();
                        int totalPopulation = BFS(i, j);
                        // 연합이 생긴 경우에만 추가
                        if (union.size() > 1) {
                            stop = false;
                            int avgPopulation = totalPopulation / union.size();
                            // 인구 수 변경
                            for (Node country : union) {
                                int x = country.x;
                                int y = country.y;
                                countries[x][y] = avgPopulation;
                            }
                        }
                    }
                }
            }

            // 연합이 존재하지 않으면 종료
            if (stop) {
                break;
            }

            day++; // 일수++
        }

        System.out.println(day);
    }

    private static int BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        union.add(new Node(x, y));
        int totalPopulation = countries[x][y];

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + DX[i];
                int ny = cur.y + DY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(countries[cur.x][cur.y] - countries[nx][ny]);
                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    union.add(new Node(nx, ny)); // 연합에 추가
                    totalPopulation += countries[nx][ny]; // 총 인구 수에 +
                }
            }
        }

        return totalPopulation;
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