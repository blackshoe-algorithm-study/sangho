package week9_0515;

import java.io.*;
import java.util.*;

public class 문제집 {
    private static int N;
    private static int M;
    private static List<Integer>[] graph;
    private static int[] lock;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        lock = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            graph[fst].add(sec);
            lock[sec]++;
        }

        bfs();
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (lock[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int pos = q.poll();
            unlock(pos);
            sb.append(pos).append(" ");

            for (int next : graph[pos]) {
                if (lock[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }

    private static void unlock(int num) {
        for (int unlock : graph[num]) {
            lock[unlock]--;
        }
    }
}