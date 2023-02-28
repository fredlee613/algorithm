package ch04;

import java.io.*;
import java.util.HashMap;

/**
 * 2. 아나그램(해쉬)
 */
public class Q02 {
    String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (Character c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (Character c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        if (map1.size() == map2.size()) {
            for (Character c : map1.keySet()) {
                if (map2.containsKey(c)) {
                    if (map1.get(c) != map2.get(c)) {
                        answer = "NO";
                    }
                } else {
                    answer = "NO";
                    break;
                }
            }
        } else {
            answer = "NO";
        }
        return answer;
    }

    String solution_final (String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q02 q02 = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q02.solution_final(stdIn.readLine(), stdIn.readLine()));
        stdIn.close();
        stdOut.close();
    }
}
