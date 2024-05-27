package week11_0527;

import java.io.*;
import java.util.*;

public class 치킨배달 {
    private static List<Set<Integer>> chickenLocations;
    private static int N, M;
    private static List<Node> houses;
    private static List<Node> chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 선택할 치킨집의 개수

        houses = new ArrayList<>();
        chickens = new ArrayList<>();
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

        int result = Integer.MAX_VALUE;
        chickenLocations = new ArrayList<>();
        createNumberSet(0, new HashSet<>());

        for (Set<Integer> locations : chickenLocations) {
            int currentDistance = 0;
            for (Node house : houses) {
                int minDist = Integer.MAX_VALUE;
                for (int location : locations) {
                    int chickenX = chickens.get(location).x;
                    int chickenY = chickens.get(location).y;

                    int dist = Math.abs(house.x - chickenX) + Math.abs(house.y - chickenY);
                    minDist = Math.min(minDist, dist);
                }
                currentDistance += minDist;
            }
            result = Math.min(result, currentDistance);
        }

        System.out.println(result);
    }

    private static void createNumberSet(int start, Set<Integer> set) {
        if (set.size() == M) {
            chickenLocations.add(new HashSet<>(set));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            set.add(i);
            createNumberSet(i + 1, set);
            set.remove(i);
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