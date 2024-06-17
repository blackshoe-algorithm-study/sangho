package week13_0617;

import java.io.*;
import java.util.*;

public class 최소비용_구하기 {
    private static final int INF = Integer.MAX_VALUE;
    private static int[] dist;
    private static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        dijkstra(start);

        System.out.println(dist[goal]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.vertex;
            int curDist = curNode.weight;

            if (curDist > dist[cur]) continue;

            for (Node node : graph.get(cur)) {
                int next = node.vertex;
                int weight = node.weight;

                if (dist[cur] + weight < dist[next]) {
                    dist[next] = dist[cur] + weight;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }
    }
}