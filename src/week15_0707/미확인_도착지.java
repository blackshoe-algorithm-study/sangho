package week15_0707;

import java.io.*;
import java.util.*;

public class 미확인_도착지 {
    private static List<Node>[] graph;
    private static final int INF = Integer.MAX_VALUE;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 노드 개수
            int M = Integer.parseInt(st.nextToken()); // 간선 개수
            int K = Integer.parseInt(st.nextToken()); // 목적지 후보 개수
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 출발지
            int G = Integer.parseInt(st.nextToken()); // V1
            int H = Integer.parseInt(st.nextToken()); // V2

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, w));
                graph[b].add(new Node(a, w));
            }

            int[] sStartDist = dijkstra(S);
            int[] hStartDist = dijkstra(H);

            List<Node> answers = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                int candidateLoc = Integer.parseInt(br.readLine());
                if (dist[candidateLoc] != INF) {
                    answers.add(new Node(candidateLoc, dist[candidateLoc]));
                }
            }

            int minWeight = answers.get(0).weight;
            for (Node answer : answers) {
                if (answer.weight != minWeight) {
                    break;
                }
                System.out.println(answer.vertex + " ");
            }
        }
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

            for (Node nextNode : graph[cur]) {
                int next = nextNode.vertex;
                int nextWeight = nextNode.weight;

                if (dist[cur] + nextWeight < dist[next]) {
                    dist[next] = dist[cur] + nextWeight;
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
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
