package week22_1008;

import java.io.*;

public class 쿼드트리 {
    private static int N;
    private static int[][] graph;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        sb = new StringBuilder();
        divideAndConquer(N, 0, 0);

        System.out.println(sb);
    }

    private static void divideAndConquer(int n, int x, int y) {
        int startNum = graph[x][y];

        // n x n 영역에서 값이 모두 같은지 확인
        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[x + i][y + j] != startNum) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        // 모든 값이 같다면 해당 숫자 추가
        if (isSame) {
            sb.append(startNum);
        } else {
            // 값이 다르면 4등분하여 재귀 호출
            sb.append('(');
            int nextInterval = n / 2;
            divideAndConquer(nextInterval, x, y);
            divideAndConquer(nextInterval, x, y + nextInterval);
            divideAndConquer(nextInterval, x + nextInterval, y);
            divideAndConquer(nextInterval, x + nextInterval, y + nextInterval);
            sb.append(')');
        }
    }
}