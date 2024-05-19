package week8_0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀_프로젝트 {
    private static int[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                int n = arr[i];
                if (!visited[n]) {
                    dfs(i, n);
                }
            }

            int answer = 0; // 팀에 속하지 못한 학생들의 수
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) answer++;
            }

            System.out.println(answer);
        }

    }

    private static boolean dfs(int org, int cur) {
        int next = arr[cur];
        if (next == org) return true;

        if (!visited[next]) {
            if (dfs(org, next)) {
                visited[next] = true;
                return true;
            }
        }

        return false;
    }
}