package week3_0401;

import java.util.*;
import java.io.*;

public class 회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> timeTable = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] time = new int[2];

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            time[0] = start; time[1] = end;

            timeTable.add(time);
        }

        // 시작 시간 기준, 오름차순 정렬
        Collections.sort(timeTable, (o1, o2) -> o1[0] - o2[0]);
        // 종료 시간 기준, 오름차순 정렬
        Collections.sort(timeTable, (o1, o2) -> o1[1] - o2[1]);

        /* 리스트 원소 확인용
        for (int[] t : timeTable) {
            System.out.println(Arrays.toString(t));
        } */

        int cnt = 1; // 최소 1개는 가능
        int lastEndTime = timeTable.get(0)[1]; // 가장 종료 시간이 빠른 회의

        for (int i = 1; i < N; i++) {
            int curStartTime = timeTable.get(i)[0];
            int curEndTime = timeTable.get(i)[1];

            if (curStartTime >= lastEndTime) {
                // 새로운 회의를 시작할 수 있는 경우
                lastEndTime = curEndTime;
                cnt++;

                // System.out.println("START : " + curStartTime + " END : " + curEndTime);
            }
        }

        System.out.println(cnt);
    }
}