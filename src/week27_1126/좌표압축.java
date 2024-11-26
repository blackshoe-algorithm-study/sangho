package week27_1126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 좌표 리스트 저장
        int[] originNums = new int[N];
        for (int i = 0; i < N; i++) {
            originNums[i] = Integer.parseInt(st.nextToken());
        }

        // 중복 제거 및 정렬된 좌표 리스트 생성
        int[] sortedNums = Arrays.copyOf(originNums, N);
        Arrays.sort(sortedNums);

        // 좌표 압축 맵핑 생성
        Map<Integer, Integer> coordinateMap = new HashMap<>();
        int rank = 0; // 압축 좌표 값
        for (int num : sortedNums) {
            if (!coordinateMap.containsKey(num)) {
                coordinateMap.put(num, rank++);
            }
        }

        // 결과 생성
        StringBuilder sb = new StringBuilder();
        for (int num : originNums) {
            sb.append(coordinateMap.get(num)).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
