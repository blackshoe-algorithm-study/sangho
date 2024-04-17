package week5_0417;

import java.io.*;
import java.util.*;

public class 나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int needTree = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int high = trees[N - 1];
        int result = binarySearch(trees, high, needTree);

        System.out.println(result);
    }

    private static int binarySearch(int[] trees, int end, int needTree) {
        int low = 0;
        int high = end;
        int cut = 0;
        int answer = 0;
        while (low <= high) {
            cut = (low + high) / 2; // 절단기 높이 설정

            long sum = cutTree(trees, cut);

            if (sum == needTree) {
                // 같은 경우 종료
                answer = cut;
                break;
            }

            if (sum > needTree) {
                // 많이 자름 -> cut을 올림
                answer = Math.max(answer, cut);
                low = cut + 1;
            } else if (sum < needTree) {
                // 적게 자름 -> cut을 내림
                high = cut - 1;
            }
        }

        return answer;
    }

    private static long cutTree(int[] trees, int cut) {
        long sum = 0;

        for (int tree : trees) {
            // 나무 자르기
            if (tree - cut > 0) {
                // cut보다 나무가 높은 경우만
                sum += tree - cut;
            }
        }

        return sum;
    }
}