package week9_0515;

import java.io.*;
import java.util.*;

public class 보석_도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        PriorityQueue<Integer> bags = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(weight, value));
        }
        jewels.sort(Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            int bagLimit = Integer.parseInt(br.readLine());

            bags.offer(bagLimit);
        }

        long result = 0;
        while (!jewels.isEmpty() && !bags.isEmpty()) {
            int bagLimit = bags.poll();

            for (Jewel jewel : jewels) {
                int weight = jewel.weight;
                int value = jewel.value;

                if (bagLimit >= weight) {
                    result += value;
                    jewels.remove(jewel);
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {

            if (this.value == o.value) {
                return Integer.compare(this.weight, o.weight);
            }

            return Integer.compare(this.value, o.value);
        }
    }
}