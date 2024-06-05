package week12_0605;

import java.io.*;
import java.util.*;

public class N과M_1 {
    private static List<String> numbers;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new ArrayList<>();
        createNumberSet("");

        StringBuilder sb = new StringBuilder();
        for (String num : numbers) {
            for (int i = 0; i < num.length(); i++) {
                sb.append(num.charAt(i)).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void createNumberSet(String num) {
        if (num.length() == M) {
            numbers.add(num);
            return;
        }

        for (int i = 1; i <= N ; i++) {
            if (!num.contains(String.valueOf(i))) {
                createNumberSet(num + i);
            }
        }
    }
}