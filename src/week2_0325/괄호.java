package week2_0325;

import java.util.*;
import java.io.*;
public class 괄호 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            Stack<String> stk = new Stack<>();
            boolean flag = true;

            for (int j = 0; j < line.length(); j++) {
                String s = "" + line.charAt(j);

                if (s.equals("(")) {
                    stk.push(s);
                } else {
                    if (stk.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stk.pop();
                }
            }

            if (flag && stk.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
