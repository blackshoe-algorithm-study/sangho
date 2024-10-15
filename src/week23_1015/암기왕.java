package week23_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암기왕 {
    private static int[] note1;
    private static int[] note2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            note1 = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            note2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                note2[i] = Integer.parseInt(st.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            for (int n : note2) {
                if (isExistInNote1(n)) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }

            System.out.print(sb);
        }
    }

    private static boolean isExistInNote1(int n) {
        int left = 0;
        int right = note1.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            int findNum = note1[mid];

            if (findNum == n) {
                return true;
            }
            if (findNum > n) {
                right = mid - 1;
            }
            if (findNum < n) {
                left = mid + 1;
            }
        }

        return false;
    }
}