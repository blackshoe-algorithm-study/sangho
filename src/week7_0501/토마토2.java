package week7_0501;

import java.io.*;
import java.util.*;

public class 토마토2 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static final int[] DH = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken()); // 가로
        int H = Integer.parseInt(st.nextToken()); // 세로
        int T = Integer.parseInt(st.nextToken()); // 높이

        int[][][] graph = new int[T][H][W];
        boolean[][][] visited = new boolean[T][H][W];
        Queue<Node> q = new LinkedList<>();
        int needCnt = 0;

        // 그래프 입력, 높이까지 고려
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < H; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < W; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    graph[i][j][k] = tomato;
                    // 익어야 하는 토마토 개수++
                    if (tomato == 0) needCnt++;
                        // 기존 토마토
                    else if (tomato == 1) {
                        q.offer(new Node(i, j, k, 0));
                    }
                }
            }
        }

        // 결과 초기값 설정
        int result;
        if (needCnt == 0) {
            // 이미 모든 토마토가 익어있는 상태
            result = 0;
        } else {
            result = -1;
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int h = cur.h;
            int x = cur.x;
            int y = cur.y;
            int day = cur.day;

            if (needCnt == 0) {
                result = day;
            }

            // 상하좌우 이동
            for (int j = 0; j < 4; j++) {
                int nx = x + DX[j];
                int ny = y + DY[j];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (!visited[h][nx][ny] && graph[h][nx][ny] == 0) {
                    visited[h][nx][ny] = true;
                    needCnt--; // 익어야 하는 토마토 개수--
                    q.offer(new Node(h, nx, ny, day + 1)); // 일수++
                }
            }

            // 위아래 이동
            for (int i = 0; i < 2; i++) {
                int nh = h + DH[i];

                if (nh < 0 || nh >= T) continue;

                if (!visited[nh][x][y] && graph[nh][x][y] == 0) {
                    visited[nh][x][y] = true;
                    needCnt--; // 익어야 하는 토마토 개수--
                    q.offer(new Node(nh, x, y, day + 1)); // 일수++
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int h;
        int x;
        int y;
        int day;

        Node(int  h, int x, int y, int day) {
            this.h = h;
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}