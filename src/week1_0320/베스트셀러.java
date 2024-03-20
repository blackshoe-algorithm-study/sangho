package week1_0320;

import java.util.*;
import java.io.*;

public class 베스트셀러 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();

            map.put(bookName, map.getOrDefault(bookName, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        Collections.sort(list, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        System.out.println(list.get(0));
    }
}