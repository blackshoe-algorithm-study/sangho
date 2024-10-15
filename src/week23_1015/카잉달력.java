package week23_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카잉달력 {
    private static int M;
    private static int N;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int year = findYear();

            sb.append(year).append('\n');
        }

        System.out.print(sb);
    }

    private static int findYear() {
        int k = x;

        // M * N이 마지막 해
        while (k <= M * N) {
            if ((k - x) % M == 0 && (k - y) % N == 0) {
                return k;
            }
            k += M;
        }
        return -1;
    }
}