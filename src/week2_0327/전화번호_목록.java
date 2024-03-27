package week2_0327;

import java.util.*;
import java.io.*;

public class 전화번호_목록 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            List<Long> phones = new ArrayList<>();
            // 전화번호들을 저장
            for (int n = 0; n < N; n++) {
                phones.add(Long.parseLong(br.readLine()));
            }

            Collections.sort(phones);

            System.out.println(find(phones));
        }
    }

    private static String find(List<Long> phones) {
        for (int i = 0; i < phones.size() - 1; i++) {
            String cur = String.valueOf(phones.get(i));
            // 본인보다 큰 숫자들만 탐색
            for (int j = i + 1; j < phones.size(); j++) {
                String next = String.valueOf(phones.get(j));
                boolean flag = false;

                for (int k = 0; k < cur.length(); k++) {
                    // 한 자리씩 비교
                    if (cur.charAt(k) != next.charAt(k)) {
                        // 통과
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}