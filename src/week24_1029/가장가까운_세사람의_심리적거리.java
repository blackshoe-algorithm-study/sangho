package week24_1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장가까운_세사람의_심리적거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nearestCount = calculateNearestCount(N, st);
            sb.append(nearestCount).append('\n');
        }

        System.out.print(sb);
    }

    private static int calculateNearestCount(int N, StringTokenizer st) {
        if (N > 32) {
            // 32명 초과일 시 무조건 MBTI가 겹치는 사람이 2명 발생함
            return 0;
        }
        String[] people = new String[N];
        for (int i = 0; i < N; i++) {
            people[i] = st.nextToken();
        }

        int nearestCount = 10;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int z = 0; z < N; z++) {
                    if (x == y || y == z || x == z) {
                        continue;
                    }
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        if (people[x].charAt(k) != people[y].charAt(k)) {
                            cnt++;
                        }
                        if (people[y].charAt(k) != people[z].charAt(k)) {
                            cnt++;
                        }
                        if (people[x].charAt(k) != people[z].charAt(k)) {
                            cnt++;
                        }
                    }
                    nearestCount = Math.min(nearestCount, cnt);
                }
            }
        }

        return nearestCount;
    }
}