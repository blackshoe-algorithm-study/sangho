package week24_1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의_부모찾기 {
    private static int[] parents;
    private static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        for (int i = 1; i < N + 1 ; i++) {
            map.put(i, new ArrayList<>());
        }
        StringTokenizer st;
        for (int j = 0; j < N - 1; j++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            // 양방향 간선
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        parents = new int[N + 1];
        parents[1] = 1;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int k = 2; k < N + 1; k++) {
            sb.append(parents[k]).append('\n');
        }

        System.out.print(sb);
    }

    private static void dfs(int parent) {
        for (int child : map.get(parent)) {
            if (parents[child] == 0) {
                parents[child] = parent;
                dfs(child);
            }
        }
    }
}