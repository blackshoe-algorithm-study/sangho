package week8_0506;

import java.io.*;
import java.util.*;

public class 바이러스 {
    private static int answer = 0;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양방향
            map.get(v).add(e);
            map.get(e).add(v);
        }
        visited = new boolean[N + 1];
        dfs(1, map);

        System.out.println(answer);
    }

    private static void dfs(int cur, Map<Integer, List<Integer>> map) {
        visited[cur] = true;

        for (int next : map.get(cur)) {
            if (!visited[next]) {
                answer++;
                dfs(next, map);
            }
        }
    }
}