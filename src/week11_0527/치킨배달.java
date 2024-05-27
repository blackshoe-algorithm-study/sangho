package week11_0527;

import java.io.*;
import java.util.*;

public class 치킨배달 {
    private static List<Set<Integer>> chickenLocations;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 선택할 치킨집의 개수

        List<Node> houses = new ArrayList<>();
        List<Node> chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int info = Integer.parseInt(st.nextToken());

                if (info == 1) {
                    houses.add(new Node(i, j));
                } else if (info == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        int chickenNum = chickens.size() - 1;
        chickenLocations = new ArrayList<>();
        createNumberSet(M, chickenNum, new HashSet<>());

        int result = 0;
        for (Set<Integer> locations : chickenLocations) {
            for (Node house : houses) {
                int houseX = house.x;
                int houseY = house.y;
                int minDist = 101;

                for (int location : locations) {
                    int chickenX = chickens.get(location).x;
                    int chickenY = chickens.get(location).y;

                    int dist = Math.abs(houseX - chickenX) + Math.abs(houseY - chickenY);
                    minDist = Math.min(minDist, dist);
                }

                result += minDist;
            }
        }

        System.out.println(result);
    }

    private static void createNumberSet(int choiceNum, int chickenNum, Set<Integer> set) {
        if (set.size() == choiceNum) {
            chickenLocations.add(set);
        }

        for (int i = 0; i <= chickenNum; i++) {
            if (set.add(i)) {
                set.add(i);
                createNumberSet(choiceNum, chickenNum, set);
            }
        }
    }


    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
