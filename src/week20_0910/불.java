package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            char[][] graph = new char[N][M];
            Node start = null;
            Queue<Node> q = new LinkedList<>();
            // 그래프 생성
            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < M; j++) {
                    graph[i][j] = row.charAt(j);
                    if (row.charAt(j) == '@') {
                        start = new Node(i, j, 0, false);
                    } else if (row.charAt(j) == '*') {
                        q.offer(new Node(i, j, 0, true));
                    }
                }
            }
            // 맨 뒤에 넣어줌
            q.offer(start);

            int result = bfs(graph, q);
            if (result == -1) {
                sb.append("IMPOSSIBLE");
            } else {
                sb.append(result);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int bfs(char[][] graph, Queue<Node> q) {
        boolean[][] visited = new boolean[N][M];
        boolean[][] fireVisited = new boolean[N][M];

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            boolean isFire = node.isFire;

            if (isFire) {
                fireVisited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + DX[i];
                    int ny = y + DY[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || fireVisited[nx][ny]) {
                        continue;
                    }
                    // 불이 옮겨붙음
                    if (graph[nx][ny] == '@' || graph[nx][ny] == '.') {
                        graph[nx][ny] = '*';
                        fireVisited[nx][ny] = true;
                        q.offer(new Node(nx, ny, 0, true));
                    }
                }
            } else {
                visited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + DX[i];
                    int ny = y + DY[i];

                    // 탈출한 경우
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        return node.time + 1;
                    }
                    // 상근이 이동
                    if (!visited[nx][ny] && graph[nx][ny] == '.' && !fireVisited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, node.time + 1, false));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        int time;
        boolean isFire;

        Node(int x, int y, int time, boolean isFire) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isFire = isFire;
        }
    }
}