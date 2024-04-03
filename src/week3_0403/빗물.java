package week3_0403;

import java.io.*;
import java.util.StringTokenizer;

public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()); // 세로
        int W = Integer.parseInt(st.nextToken()); // 가로

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[W]; // 숫자들을 배열에 저장
        for (int i = 0; i < W; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[W]; // 정방향
        int[] reverseArr = new int[W]; // 역방향

        // 정방향, 역방향으로 최대 높이를 저장
        int arrMaxNum = 0; int reverseArrMaxNum = 0;
        for (int i = 0; i < W; i++) {

            arrMaxNum = Math.max(arrMaxNum, nums[i]);
            reverseArrMaxNum = Math.max(reverseArrMaxNum, nums[W - i - 1]);

            arr[i] = arrMaxNum;
            reverseArr[W - i - 1] = reverseArrMaxNum;
        }

        int sum = 0;
        for (int i = 0; i < W; i++) {
            int limit = Math.min(arr[i], reverseArr[i]); // 두 배열 중 낮은 높이를 선택

            sum += (limit - nums[i]); // 칸마다 고이는 빗물의 양을 더해줌
        }

        System.out.println(sum);
    }
}
