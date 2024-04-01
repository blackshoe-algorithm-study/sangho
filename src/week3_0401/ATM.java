package week3_0401;

import java.util.*;
import java.io.*;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        int totalSum = 0;
        int intervalSum = 0;
        for (int p : people) {
            intervalSum += p;
            totalSum += intervalSum;
        }

        System.out.println(totalSum);
    }
}
