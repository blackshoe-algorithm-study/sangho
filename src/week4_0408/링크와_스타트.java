package week4_0408;

import java.io.*;
import java.util.*;
public class 링크와_스타트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                table [i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구현 필요
    }

    // 모든 조합을 반환하는 메서드
}
