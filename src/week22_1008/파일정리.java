package week22_1008;

import java.io.*;
import java.util.*;

public class 파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            String extension = fileName.split("\\.")[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            int count = map.get(key);
            sb.append(key).append(" ").append(count).append('\n');
        }

        System.out.println(sb);
    }
}