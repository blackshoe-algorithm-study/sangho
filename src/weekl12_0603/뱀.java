package weekl12_0603;

import java.io.*;
import java.util.*;

public class 뱀 {
    // 좌 상 우 하
    private static final int[] DX = {0, -1, 0, 1};
    private static final int[] DY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        // 사과의 위치
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x - 1][y - 1] = 1;
        }

        // 머리 이동 커맨드
        int L = Integer.parseInt(br.readLine());
        String[] cmds = new String[100001];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String cmd = String.valueOf(st.nextToken());
            cmds[t] = cmd;
        }

        // 게임 시작
        int time = 0;
        int head = 2; // 처음 머리는 오른쪽
        int x = 0;
        int y = 0;
        graph[x][y] = 2;
        Queue<Node> snake = new LinkedList<>(); // 뱀의 위치
        snake.offer(new Node(x, y));
        while (true) {
            int nx = x + DX[head];
            int ny = y + DY[head];

            // 벽 or 자신의 몸에 부딪힌 경우 게임 종료
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] == 2) {
                break;
            }

            // 사과를 먹고 몸을 늘림
            if (graph[nx][ny] == 1) {
                graph[nx][ny] = 2;
            }
            // 사과가 없으므로 이동 후 몸길이를 되돌림
            else {
                graph[nx][ny] = 2;

                Node tail = snake.poll(); // 뱀의 꼬리 위치
                graph[tail.x][tail.y] = 0;
            }

            snake.offer(new Node(nx, ny));
            x = nx;
            y = ny;
            time++;

            // 머리 방향을 바꿈
            if (!Objects.isNull(cmds[time])) {
                head = changeHeadLocation(head, cmds[time]);
            }
        }

        System.out.println(time + 1);
    }

    private static int changeHeadLocation(int head, String cmd) {
        if (cmd.equals("L")) {
            head--;
            if (head < 0) {
                head = 3;
            }
        } else if (cmd.equals("D")) {
            head++;
            if (head > 3) {
                head = 0;
            }
        }

        return head;
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