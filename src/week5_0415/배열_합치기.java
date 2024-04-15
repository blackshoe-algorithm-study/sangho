package week5_0415;

import java.io.*;
import java.util.*;

public class 배열_합치기 {
    public static void main(String[] args) throws IOException {
        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());

                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                    nums.add(num);
                }
            }
        }

        Collections.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            for (int i = 0; i < map.get(num); i++) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}