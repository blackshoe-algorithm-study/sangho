package week19_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(bfs(A, B)).append('\n');
        }
        System.out.println(sb);
    }

    private static String bfs(int start, int end) {
        boolean[] visited = new boolean[10001];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, ""));
        visited[start] = true;
        String result = "";

        while (!q.isEmpty()) {
            Node node = q.poll();
            int num = node.num;
            String cmd = node.cmd;

            if (num == end) {
                result = cmd;
                break;
            }

            int numD = functionD(num);
            if (!visited[numD]) {
                q.offer(new Node(numD, cmd + "D"));
                visited[numD] = true;
            }
            int numS = functionS(num);
            if (!visited[numS]) {
                q.offer(new Node(numS, cmd + "S"));
                visited[numS] = true;
            }
            int numL = functionL(num);
            if (!visited[numL]) {
                q.offer(new Node(numL, cmd + "L"));
                visited[numL] = true;
            }
            int numR = functionR(num);
            if (!visited[numR]) {
                q.offer(new Node(numR, cmd + "R"));
                visited[numR] = true;
            }
        }

        return result;
    }

    private static int functionD(int num) {
        return num * 2 % 10000;
    }

    private static int functionS(int num) {
        return num - 1 < 0 ? 9999 : num - 1;
    }

    private static int functionL(int num) {
        return num % 1000 * 10 + num / 1000;
    }

    private static int functionR(int num) {
        return num % 10 * 1000 + num / 10;
    }

    static class Node {
        int num;
        String cmd;

        Node(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
}