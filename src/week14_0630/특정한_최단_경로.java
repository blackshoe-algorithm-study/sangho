package week14_0630;

import java.io.*;
import java.util.*;

public class 특정한_최단_경로 {
    private static List<Node>[] graph;
    private static final int INF = Integer.MAX_VALUE;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] d1 = dijkstra(1);
        int[] d2 = dijkstra(v1);
        int[] d3 = dijkstra(v2);

        int result = -1;
        if (d1[v1] != INF && d2[v2] != INF && d3[N] != INF) {
            result = Math.min((d1[v1] + d2[v2] + d3[N]), (d1[v2] + d3[v1] + d2[N]));
        }
        System.out.println(result);
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.vertex;
            int curWeight = curNode.weight;

            if (curWeight > dist[cur]) {
                continue;
            }

            for (Node node : graph[cur]) {
                int next = node.vertex;
                int nextWeight = node.weight;

                if (dist[cur] + nextWeight < dist[next]) {
                    dist[next] = dist[cur] + nextWeight;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
