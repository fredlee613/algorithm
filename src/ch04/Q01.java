package ch04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 학급 회장(해쉬)
 */
public class Q01 {
    String solution(int count, String input) {
        String answer = "";
        int biggest = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = input.toCharArray();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) > biggest){
                biggest = map.get(c);
                answer = Character.toString(c);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q01 q01 = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(stdIn.readLine());
        stdOut.write(q01.solution(count, stdIn.readLine()));
        stdIn.close();
        stdOut.close();
    }
}
