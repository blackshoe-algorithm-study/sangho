package week28_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String originWord = br.readLine();
        String findWord = br.readLine();
        int len = findWord.length();

        int idx = 0;
        int cnt = 0;
        while (idx <= originWord.length() - len) {
            String curWord = originWord.substring(idx, idx + len);
            if (curWord.equals(findWord)) {
                cnt++;
                idx += len;
            } else {
                idx++;
            }
        }

        System.out.print(cnt);
    }
}
