package week29_1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봄버맨 {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private static int[][] board;
    private static int R;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                String cmd = String.valueOf(row.charAt(j));
                if (".".equals(cmd)) {
                    board[i][j] = -1;
                } else if ("O".equals(cmd)) {
                    board[i][j] = 0; // 초기에 설치된 폭탄
                }
            }
        }

        if (N >= 2) {
            int time = 2;
            boolean isBurst = false; // true인 경우, 3초 전에 설치된 폭탄이 폭발함
            while (time <= N) {
                if (isBurst) {
                    burstBombs(time);
                    isBurst = false;
                } else {
                    plantBombs(time);
                    isBurst = true;
                }
                time++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != -1) {
                    sb.append("O");
                } else {
                    sb.append(".");
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 3초 전에 설치된 폭탄을 터트리는 메서드
    private static void burstBombs(int curTime) {
        int nx;
        int ny;
        int atTime;
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                atTime = board[x][y];
                if (atTime != -1 && atTime + 3 == curTime) {
                    board[x][y] = -1;

                    for (int k = 0; k < 4; k++) {
                        nx = x + DX[k];
                        ny = y + DY[k];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                            continue;
                        }
                        if (board[nx][ny] + 3 == curTime) {
                            // 이번 time에 터져야 하는 폭탄이면 제거 x
                            continue;
                        }
                        board[nx][ny] = -1;
                    }
                }
            }
        }
    }

    // 빈 공간에 폭탄을 설치하는 메서드
    private static void plantBombs(int curTime) {
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (board[x][y] == -1) {
                    board[x][y] = curTime;
                }
            }
        }
    }
}
