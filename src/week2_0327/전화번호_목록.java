package week2_0327;

import java.util.*;
import java.io.*;

public class 전화번호_목록 {
    private static final StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] phones = new String[N]; // 전화번호를 저장하는 배열
            Map<String, Integer> map = new HashMap<>();

            // 전화번호들을 저장
            for (int n = 0; n < N; n++) {
                String phone = br.readLine();
                phones[n] = phone;
                map.put(phone, n);
            }

            find(phones, map);
        }

        System.out.println(answer);
    }

    private static void find(String[] phones, Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (String phone : phones) {
            // 본인은 제외해야 하므로 : 전체 길이 - 1
            for (int i = 0; i < phone.length() - 1; i++) {
                sb.append(phone.charAt(i));

                if (map.containsKey(sb.toString())) {
                    answer.append("NO").append('\n');
                    return;
                }
            }

            sb.setLength(0);
        }

        answer.append("YES").append('\n');
    }
}