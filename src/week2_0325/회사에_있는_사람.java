package week2_0325;

import java.io.*;
import java.util.*;

public class 회사에_있는_사람 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if (cmd.equals("enter")) map.put(name, 1);
            else map.put(name, map.get(name) - 1);
        }

        List<String> people = new ArrayList<>(map.keySet());
        Collections.sort(people, Collections.reverseOrder());

        for (String person : people)  {
            if (map.get(person) != 0) {
                System.out.println(person);
            }
        }
    }
}