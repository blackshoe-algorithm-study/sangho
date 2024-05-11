package week8_0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 효율적인_해킹 {
    public static int N, M;		        // N: 컴퓨터의 수, M : 관계의 수
    public static Computer[] coms;		// 컴퓨터 배열
    public static boolean[] visited;	// 방문 체크 변수
    public static int[] answer;			// 각 컴퓨터에서 접근 가능한 컴퓨터 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        coms = new Computer[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            coms[i] = new Computer(i);
        }

        // B -> A로 매핑
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            coms[B].list.add(coms[A]);
        }

        int maxNum = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];

            dfs(i, i);
            maxNum = Math.max(maxNum, answer[i]);
        }

        // 최대값인 경우에만 추가
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxNum) {
                sb.append(i).append(" ");
            }
        }
        
        System.out.println(sb);
    }
    
    private static void dfs(int org, int cur) {
        visited[cur] = true;

        for (Computer computer : coms[cur].list) {
            if (!visited[computer.idx]) {
                dfs(org, computer.idx);
                answer[org]++;
            }
        }
    }

    static class Computer{
        int idx;
        ArrayList<Computer> list; // 접근 가능한 컴퓨터 리스트

        public Computer(int idx) {
            this.idx = idx;
            list = new ArrayList<>();
        }
    }
}