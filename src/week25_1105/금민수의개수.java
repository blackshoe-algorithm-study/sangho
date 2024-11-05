package week25_1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 금민수의개수 {
    private static int result;
    private static int A;
    private static int B;
    private static boolean stopFlag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        result = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("");

        stopFlag = false;
        while (!stopFlag) {
            String stringNum = q.poll();
            String plusFourNum = stringNum + "4";
            String plusSevenNum = stringNum + "7";
            if (isKeumMinSu(plusFourNum)) {
                result++;
            }
            if (isKeumMinSu(plusSevenNum)) {
                result++;
            }
            q.offer(plusFourNum);
            q.offer(plusSevenNum);
        }
        System.out.print(result);
    }

    private static boolean isKeumMinSu(String stringNum) {
        long num = Long.parseLong(stringNum);
        if (num < A) {
            return false;
        }
        if (num > B) {
            stopFlag = true;
            return false;
        }
        return true;
    }
}