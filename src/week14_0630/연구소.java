package week14_0630;

import java.io.*;
import java.util.*;

public class 연구소 {
    private static int N;
    private static int M;
    private static int[][] graph;
    private static List<Node> viruses;
    private static List<Node> blanks;
    private static List<Node[]> walls;
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        viruses = new ArrayList<>();
        blanks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cmd = Integer.parseInt(st.nextToken());
                graph[i][j] = cmd;
                if (cmd == 0) {
                    blanks.add(new Node(i, j));
                } else if (cmd == 2) {
                    viruses.add(new Node(i, j));
                }
            }
        }

        walls = new ArrayList<>();
        createWallSets();

        int result = 0;
        for (int i = 0; i < walls.size(); i++) {
            Node[] nodes = walls.get(i);
            for (Node node : nodes) {
                graph[node.x][node.y] = 1;
            }

            result = Math.max(result, bfs());

            for (Node node : nodes) {
                graph[node.x][node.y] = 0;
            }
        }

        System.out.println(result);
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        for (Node virus : viruses) {
            q.offer(virus);
        }

        int infectionCnt = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (nx >= N || nx < 0 || ny >= M || ny < 0) {
                    continue;
                }
                if (!visited[nx][ny] && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    infectionCnt++;
                }
            }
        }

        // 빈 칸의 개수 - 감염된 개수 - 새로 세운 벽 개수
        return blanks.size() - infectionCnt - 3;
    }

    private static void createWallSets() {
        for (int i = 0; i < blanks.size(); i++) {
            for (int j = i + 1; j < blanks.size(); j++) {
                for (int k = j + 1; k < blanks.size(); k++) {
                    Node[] nodes = new Node[3];
                    nodes[0] = blanks.get(i);
                    nodes[1] = blanks.get(j);
                    nodes[2] = blanks.get(k);
                    walls.add(nodes);
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