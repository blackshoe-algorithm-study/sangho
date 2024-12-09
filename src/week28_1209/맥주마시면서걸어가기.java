package week28_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 맥주마시면서걸어가기 {
    private static final int MAX_MOVEMENT_DISTANCE = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            Node start = new Node(sx, sy);

            List<Node> conveniences = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                conveniences.add(new Node(x, y));
            }

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            Node end = new Node(ex, ey);

            if (bfs(start, end, conveniences)) {
                sb.append("happy").append('\n');
            } else {
                sb.append("sad").append('\n');
            }
        }

        System.out.print(sb);
    }

    private static boolean bfs(Node start, Node end, List<Node> conveniences) {
        boolean[] visited = new boolean[conveniences.size()];
        int ex = end.x;
        int ey = end.y;

        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if (calculateDistance(x, y, ex, ey) <= MAX_MOVEMENT_DISTANCE) {
                return true;
            }

            for (int i = 0; i < conveniences.size(); i++) {
                Node convenience = conveniences.get(i);
                int cx = convenience.x;
                int cy = convenience.y;
                if (!visited[i] && calculateDistance(x, y, cx, cy) <= MAX_MOVEMENT_DISTANCE) {
                    visited[i] = true;
                    q.offer(new Node(cx, cy));
                }
            }
        }

        return false;
    }

    private static int calculateDistance(int a, int b, int c, int d) {
        return (Math.abs((c - a)) + Math.abs((d - b)));
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
