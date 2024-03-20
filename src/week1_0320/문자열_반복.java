package week1_0320;

import java.io.*;

public class 문자열_반복 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] arr = line.split(" ");

            int re = Integer.parseInt(arr[0]);
            String word = arr[1];

            for (int j = 0; j < word.length(); j++) {
                String w = "" + word.charAt(j);
                sb.append(w.repeat(re));
            }

            if (i < N - 1) sb.append('\n');
        }

        System.out.println(sb);
    }
}