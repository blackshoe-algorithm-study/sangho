package week16_0714;

import java.io.*;
import java.util.*;

public class 말이되고픈_원숭이 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static final int[] HX = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] HY = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[][] graph;
    private static boolean[][][] visited;
    private static int K;
    private static int W;
    private static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, K, 0));
        visited[0][0][K] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int k = node.k;
            int cnt = node.cnt;

            if (x == H - 1 && y == W - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (rangeCheck(nx, ny) && !visited[nx][ny][k] && graph[nx][ny] != 1) {
                    visited[nx][ny][k] = true;
                    q.offer(new Node(nx, ny, k, cnt + 1));
                }
            }

            if (k > 0) {
                for (int i = 0; i < 8; i++) {
                    int hx = x + HX[i];
                    int hy = y + HY[i];

                    if (rangeCheck(hx, hy) && !visited[hx][hy][k - 1] && graph[hx][hy] != 1) {
                        visited[hx][hy][k - 1] = true;
                        q.offer(new Node(hx, hy, k - 1, cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    private static boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < H && y >= 0 && y < W);
    }

    static class Node {
        int x;
        int y;
        int k;
        int cnt;

        Node(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}