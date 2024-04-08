package week4_0408;

import java.io.*;
import java.util.*;

public class 링크와_스타트 {
    private static List<List<Integer>> allComb;
    private static int N;
    private static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        table = new int[N][N];
        allComb = new ArrayList<>();

        // 테이블 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        createAllComb(0, new ArrayList<>());

        int result = 100000;
        for (List<Integer> comb : allComb) {
            List<Integer> otherTeam = getOtherTeam(comb);
            int start = calculateAbility(comb);
            int link = calculateAbility(otherTeam);
            result = Math.min(result, Math.abs(start - link)); // 능력치 차이가 최소가 되도록 갱신
        }

        System.out.println(result);
    }

    // 모든 팀 조합을 반환하는 메서드
    private static void createAllComb(int start, List<Integer> comb) {
        allComb.add(new ArrayList<>(comb)); // 독립된 리스트 객체로 변환하여 저장

        for (int i = start; i < N; i++) {
            comb.add(i);
            createAllComb(i + 1, comb);
            comb.remove(Integer.valueOf(i));
        }
    }

    // 상대팀을 반환하는 메서드
    private static List<Integer> getOtherTeam(List<Integer> team) {
        List<Integer> otherTeam = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!team.contains(i)) {
                otherTeam.add(i);
            }
        }
        return otherTeam;
    }

    // 팀의 능력치를 계산하여 반환하는 메서드
    private static int calculateAbility(List<Integer> team) {
        int ability = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = i + 1; j < team.size(); j++) {
                int member1 = team.get(i);
                int member2 = team.get(j);
                ability += table[member1][member2] + table[member2][member1];
            }
        }
        return ability;
    }
}
