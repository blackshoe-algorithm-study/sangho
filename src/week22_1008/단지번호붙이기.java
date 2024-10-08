package week22_1008;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static int[][] graph;
    private static boolean[][] visited;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        List<Integer> houseCounts = new ArrayList<>();

        // 좌측 상단부터 우측 하단까지, 방문하지 않은 집이 있다면 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    visited[i][j] = true;
                    int houseCount = bfs(i, j);
                    houseCounts.add(houseCount);
                }
            }
        }

        Collections.sort(houseCounts);

        StringBuilder sb = new StringBuilder();
        sb.append(houseCounts.size()).append('\n');
        for (int houseCount : houseCounts) {
            sb.append(houseCount).append('\n');
        }

        System.out.println(sb);
    }

    private static int bfs(int sx, int sy) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy));
        // 해당 단지에서의 집 개수
        int houseCount = 1;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int x = curNode.x;
            int y = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (nx >= N || nx < 0 || ny >= N || ny < 0) {
                    continue;
                }
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    houseCount++;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return houseCount;
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