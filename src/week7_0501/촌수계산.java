package week7_0501;

import java.io.*;
import java.util.*;

public class 촌수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] visited = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = 0;
        int result = -1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if (cur == E) {
                result = visited[E];
                break;
            }

            for (int next : map.get(cur)) {
                if (visited[next] == 0) {
                    q.offer(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }

        System.out.println(result);
    }
}