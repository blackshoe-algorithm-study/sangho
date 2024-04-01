package week3_0401;

import java.io.*;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nums = br.readLine();

        StringBuilder sb = new StringBuilder();
        boolean minusFlag = false;
        int sum = 0;
        for (int i = 0; i < nums.length(); i++) {
            Character c = nums.charAt(i);

            if (Character.isDigit(c)) {
                // 숫자인 경우
                sb.append(c);
            } else {
                // 기호인 경우
                int num = Integer.parseInt(sb.toString());
                sb.setLength(0); // StringBuilder 초기화

                if (minusFlag) {
                    // 한 번 - 가 나오면 이후로는 뺄셈만
                    sum -= num;
                    continue;
                }

                if (c == '-') {
                    // 처음 - 가 나온 경우
                    minusFlag = true;
                }

                sum += num;
            }

            if (i == nums.length() - 1) {
                // 맨 마지막 숫자 처리
                int num = Integer.parseInt(sb.toString());

                if (minusFlag) {
                    sum -= num;
                } else {
                    sum += num;
                }
            }
        }

        System.out.println(sum);
    }
}