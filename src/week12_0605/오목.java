package week12_0605;

import java.io.*;
import java.util.*;

public class 오목 {
    private static final int[][] board = new int[19][19];
    private static final int[] dx = {1, 1, 0, -1};
    private static final int[] dy = {0, 1, 1, 1};
    private static boolean isClear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Result result = find();
        int winner = result.winner;
        System.out.println(winner);
        if (winner != 0) {
            System.out.println(result.x + " " + result.y);
        }
    }

    private static Result find() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                int color = board[i][j];
                if (color != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        isClear = false;
                        dfs(color, i, j, dir, 1);

                        if (isClear) {
                            // 시작점의 직전 위치도 확인하여 육목 방지
                            boolean isSix = true;
                            int px = i - dx[dir];
                            int py = j - dy[dir];
                            if (px < 0 || px >= 19 || py < 0) {
                                isSix = false;

                            } else if (board[px][py] != color) {
                                isSix = false;
                            }

                            if (!isSix) {
                                return new Result(color, i + 1, j + 1);
                            }
                        }
                    }
                }
            }
        }

        return new Result(0, -1, -1);
    }

    private static void dfs(int color, int x, int y, int dir, int cnt) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
            // 육목이 아닌 경우
            if (cnt == 5 && board[nx][ny] != color) {
                isClear = true;
            } else if (board[nx][ny] == color) {
                dfs(color, nx, ny, dir, cnt + 1);
            }
        }
        // 5번째 바둑알이 바둑판의 끝에 위치한 경우
        else if (cnt == 5) {
            isClear = true;
        }
    }

    static class Result {
        int winner;
        int x;
        int y;

        Result(int winner, int x, int y) {
            this.winner = winner;
            this.x = x;
            this.y = y;
        }
    }
}