package week18_0731;

import java.io.*;
import java.util.*;

public class 나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> numberMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();
        for (int n = 1; n <= N; n++) {
            String name = br.readLine();
            numberMap.put(n, name);
            nameMap.put(name, n);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();
            if (Character.isAlphabetic(cmd.charAt(0))) {
                sb.append(nameMap.get(cmd)).append('\n');
            } else {
                sb.append(numberMap.get(Integer.parseInt(cmd))).append('\n');
            }
        }

        System.out.println(sb);
    }
}