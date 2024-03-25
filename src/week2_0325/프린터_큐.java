package week2_0325;

import java.util.*;
import java.io.*;

public class 프린터_큐 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());

            StringTokenizer nums = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();

            // 큐에 숫자들을 넣어줌
            for (int l = 0; l < len; l++) {
                int num = Integer.parseInt(nums.nextToken());
                q.offer(num);
            }

            while (true) {
                int maxNum = 0;
                int maxId = -1;
                int cnt = 1;

                // 매번 가장 큰 수를 찾음
                for (int i = 0; i < q.size(); i++) {
                    int n = q.poll();
                    if (n > maxNum) {
                        maxNum = n;
                        maxId = i;
                    }
                    q.offer(n);
                }

                boolean flag = false;
                for (int j = 0; j < q.size(); j++) {
                    int num = q.poll();

                    if (num != maxNum) {
                        q.offer(num);
                    } else {
                        if (maxId == id) flag = true;
                        break;
                    }
                }

                if (flag) {
                    System.out.println(cnt);
                    break;
                }

                id = q.size() - maxId;
                cnt++;
            }
        }
    }
}
