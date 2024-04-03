package week3_0403;

import java.io.*;
import java.util.*;

import static java.util.Collections.binarySearch;

public class 수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> A = new ArrayList<>();

        while (st.hasMoreTokens()) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (st2.hasMoreTokens()) {
            int num = Integer.parseInt(st2.nextToken());

            int id = binarySearch(A, num); // 있다면 0이상

            if (id >= 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}