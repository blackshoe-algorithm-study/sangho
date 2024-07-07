package week15_0707;

import java.io.*;
import java.util.*;

public class DNA_비밀번호 {
    private static int atLeastA;
    private static int atLeastC;
    private static int atLeastG;
    private static int atLeastT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String temp = br.readLine();

        st = new StringTokenizer(br.readLine());
        atLeastA = Integer.parseInt(st.nextToken());
        atLeastC = Integer.parseInt(st.nextToken());
        atLeastG = Integer.parseInt(st.nextToken());
        atLeastT = Integer.parseInt(st.nextToken());

        // 초기 세팅
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < P; i++) {
            map.put(temp.charAt(i), map.getOrDefault(temp.charAt(i), 0) + 1);
        }

        int result = 0;
        int index = 0;
        while (true) {
            if (check(map)) {
                result++;
            }
            if (index + P == S) {
                break;
            }

            Character first = temp.charAt(index);
            Character next = temp.charAt(index + P);
            map.put(first, map.get(first) - 1);
            map.put(next, map.getOrDefault(next, 0) + 1);
            index++;
        }

        System.out.println(result);
    }

    private static boolean check(Map<Character, Integer> map) {
        return map.getOrDefault('A', 0) >= atLeastA
                && map.getOrDefault('C', 0) >= atLeastC
                && map.getOrDefault('G', 0) >= atLeastG
                && map.getOrDefault('T', 0) >= atLeastT;
    }
}