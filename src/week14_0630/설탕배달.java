package week14_0630;

import java.io.*;

public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());

        int maxFiveCnt = sugar / 5;
        int result = -1;
        for (int i = maxFiveCnt; i >= 0; i--) {
            int remain = sugar - (i * 5);
            if (remain % 3 == 0) {
                result = i + (remain / 3);
                break;
            }
        }

        System.out.println(result);
    }
}