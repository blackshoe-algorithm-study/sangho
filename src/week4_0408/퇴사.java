package week4_0408;

import java.io.*;
import java.util.*;

public class 퇴사 {
    private static int[][] timeTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        timeTable = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            timeTable[i][0] = time;
            timeTable[i][1] = cost;
        }

        System.out.println(bfs(N));
    }

    private static int bfs(int N) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        int temp = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            temp = Math.max(temp, node.cost);

            for (int i = node.day; i < N; i++) {
                int nextDay = timeTable[i][0];
                int nextCost = timeTable[i][1];
                if (i + nextDay <= N) {
                    q.offer(new Node(i + nextDay, node.cost + nextCost));
                }
            }
        }

        return temp;
    }

    static class Node {
        int day;
        int cost;

        Node(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }
}