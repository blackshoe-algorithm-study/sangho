package week27_1126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단어나누기 {
    private static List<String> words;
    private static String originWord;
    private static int wordLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        originWord = br.readLine();
        wordLength = originWord.length();

        words = new ArrayList<>();
        for (int x = 0; x < wordLength; x++) {
            for (int y = x + 1; y < wordLength - 1; y++) {
                createNewWord(x, y);
            }
        }

        Collections.sort(words);
        System.out.print(words.get(0));
    }

    private static void createNewWord(int x, int y) {
        StringBuilder sb = new StringBuilder();
        // 첫 번째 부분
        for (int i = x; i >= 0; i--) {
            sb.append(originWord.charAt(i));
        }
        // 두 번째 부분
        for (int j = y; j > x; j--) {
            sb.append(originWord.charAt(j));
        }
        // 세 번째 부분
        for (int k = wordLength - 1; k > y; k--) {
            sb.append(originWord.charAt(k));
        }
        words.add(sb.toString());
    }
}
