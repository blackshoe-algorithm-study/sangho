package week29_1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {
    private static int[] switches;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        switches = new int[N + 1];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            switches[n] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                manOperation(num);
            } else if (gender == 2) {
                womanOperation(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            System.out.print(sb);
        }
    }

    // 남자 동작 메서드
    private static void manOperation(int num) {
        for (int i = num; i <= N; i += num) {
            change(i);
        }
    }

    // 여자 동작 메서드
    private static void womanOperation(int num) {
        int leftIndex;
        int rightIndex;
        int leftNum;
        int rightNum;
        // 시작점은 무조건 변경
        change(num);

        for (int i = 1; i <= N / 2; i++) {
            leftIndex = num - i;
            rightIndex = num + i;
            if (leftIndex < 1 || rightIndex > N) {
                break;
            }

            leftNum = switches[leftIndex];
            rightNum = switches[rightIndex];
            if (leftNum != rightNum) {
                break;
            }
            change(leftIndex);
            change(rightIndex);
        }
    }

    // 스위치의 번호를 바꾸는 메서드
    private static void change(int index) {
        if (switches[index] == 0) {
            switches[index] = 1;
        } else if (switches[index] == 1) {
            switches[index] = 0;
        }
    }
}
