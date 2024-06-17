package week13_0617;

import java.io.*;
import java.util.*;

public class 특정거리의_도시찾기 {
    private static final int INF = Integer.MAX_VALUE;
    private static int[] dist;
    private static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, 1));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;
        dijkstra(X);

        List<Integer> answers = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == K) {
                answers.add(i);
            }
        }

        if (!answers.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int answer : answers) {
                sb.append(answer).append('\n');
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    private static void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                Node node = graph.get(cur).get(i);
                int next = node.vertex;
                int weight = node.weight;

                if (dist[cur] + weight < dist[next]) {
                    dist[next] = dist[cur] + weight;
                    q.offer(next);
                }
            }
        }
    }

    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}