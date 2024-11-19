package week26_1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            stack = new Stack<>();
            for (int n = 0; n < N; n++) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            long maxProfit = calculateMaxProfit(stack);
            sb.append(maxProfit).append('\n');
        }

        System.out.print(sb);
    }

    private static long calculateMaxProfit(Stack<Integer> stack) {
        int curMaxPrice = 0;
        long maxProfit = 0;
        while (!stack.isEmpty()) {
            int curNum = stack.pop();

            if (curNum > curMaxPrice) {
                curMaxPrice = curNum;
            } else {
                maxProfit += curMaxPrice - curNum;
            }
        }

        return maxProfit;
    }
}