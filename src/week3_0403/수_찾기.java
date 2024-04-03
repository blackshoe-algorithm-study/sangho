package week3_0403;

import java.io.*;
import java.util.*;

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
        int maxNum = A.get(A.size() - 1);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (st2.hasMoreTokens()) {
            int num = Integer.parseInt(st2.nextToken());

            if (num > maxNum) {
                sb.append(0).append('\n');
                continue;
            }

            for (int a : A) {
                if (a > num) {
                    sb.append(0).append('\n');
                    break;
                }
                if (a == num) {
                    sb.append(1).append('\n');
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}