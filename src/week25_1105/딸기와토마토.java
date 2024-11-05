package week25_1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 딸기와토마토 {
    private static int N;
    private static int M;
    private static int K;
    private static int[][] graph;
    private static boolean[][] visited;
    private static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                graph[i][j] = n;
            }
        }

        visited = new boolean[N][M];
        nodes = new ArrayList<>();
        find();

        StringBuilder sb = new StringBuilder();
        sb.append(nodes.size()).append('\n');
        for (Node node : nodes) {
            sb.append(node.x).append(" ").append(node.y).append('\n');
        }
        System.out.print(sb);
    }

    private static void find() {
        boolean isFirst = true;
        List<Node> firstNodes = new ArrayList<>();
        int rowLimit = Math.max(0, K - N);
        int colLimit = Math.max(0, K - M);

        for (int i = 0; i <= rowLimit; i++) {
            for (int j = 0; j <= colLimit; j++) {
                if (graph[i][j] == 1) {
                    // 1. 가로
                    // 이어지는 경우
                    if (graph[i][j + 1] == 1) {
                        // 1.1. 처음 찾은 경우
                        if (isFirst) {
                            for (int rk = 0; rk < K; rk++) {
                                visited[i][j + rk] = true;
                                firstNodes.add(new Node(i + 1, j + rk + 1));
                            }
                            isFirst = false;
                        } else {
                            for (int rk = 0; rk < K; rk++) {
                                if (visited[i][j + rk]) {
                                    nodes.add(new Node(i + 1, j + rk + 1));
                                }
                            }
                            return;
                        }
                    }
                    // 2. 세로
                    // 이어지는 경우
                    if (graph[i + 1][j] == 1) {
                        // 1.1. 처음 찾은 경우
                        if (isFirst) {
                            for (int ck = 0; ck < K; ck++) {
                                visited[i + ck][j] = true;
                                firstNodes.add(new Node(i + ck + 1, j + 1));
                            }
                            isFirst = false;
                        } else {
                            for (int ck = 0; ck < K; ck++) {
                                if (visited[i + ck][j]) {
                                    nodes.add(new Node(i + ck + 1, j + 1));
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }
        // 완전히 겹치는 경우
        nodes = firstNodes;
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