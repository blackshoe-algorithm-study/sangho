package week23_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {
    private static int[][] stickers;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                stickers[0][i] = Integer.parseInt(st1.nextToken());
                stickers[1][i] = Integer.parseInt(st2.nextToken());
            }

            int maxScore = findMaxScore();
            sb.append(maxScore).append('\n');
        }

        System.out.print(sb);
    }

    // 본인 포기, 이전 최대값 or 본인 대각선 + 본인
    private static int findMaxScore() {

        for (int i = 1; i < N; i++) {
            // 위
            stickers[0][i] = Math.max(stickers[0][i] + stickers[1][i - 1], stickers[0][i - 1]);
            // 아래
            stickers[1][i] = Math.max(stickers[1][i] + stickers[0][i - 1], stickers[1][i - 1]);
        }

        return Math.max(stickers[0][N - 1], stickers[1][N - 1]);
    }
}