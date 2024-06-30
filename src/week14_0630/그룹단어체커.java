package week14_0630;

import java.io.*;
import java.util.*;

public class 그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (check(word)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean check(String word) {
        boolean isGroupWord = true;
        List<Character> chars = new ArrayList<>();
        char c = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char nc = word.charAt(i);
            if (c != nc) {
                if (chars.contains(nc)) {
                    isGroupWord = false;
                    break;
                }
                chars.add(c);
                c = nc;
            }
        }

        return isGroupWord;
    }
}