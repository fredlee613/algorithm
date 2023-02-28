package ch04;

import java.io.*;
import java.util.HashMap;

/**
 * 4. 모든 아나그램 찾기
 */
public class Q04 {
    String solution(String str1, String str2) {
        int answer = 0, lt = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char x : str2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int rt = str2.length() - 1; rt < str1.length(); rt++) {
            map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt), 0) + 1);

            // 비교
            if (map1.size() == map2.size()) {
                boolean flag = true;
                for (char x : map2.keySet()) {
                    if (!map1.containsKey(x)) {
                        flag = false;
                        break;
                    } else {
                        if (map1.get(x) != map2.get(x)){
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) answer++;
            }
            map1.put(str1.charAt(lt), map1.getOrDefault(str1.charAt(lt), 0) - 1);
            if (map1.get(str1.charAt(lt)) == 0) map1.remove(str1.charAt(lt));
            lt++;
        }


        return String.valueOf(answer);
    }

    String solution_final(String str1, String str2) {
        int answer = 0, lt = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char x : str2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int rt = str2.length() - 1; rt < str1.length(); rt++) {
            map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt), 0) + 1);

            // 비교

            if (map1.equals(map2)) answer++;

            map1.put(str1.charAt(lt), map1.getOrDefault(str1.charAt(lt), 0) - 1);
            if (map1.get(str1.charAt(lt)) == 0) map1.remove(str1.charAt(lt));
            lt++;
        }


        return String.valueOf(answer);
    }


    public static void main(String[] args) throws IOException {
        Q04 q04 = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q04.solution_final(stdIn.readLine(), stdIn.readLine()));
        stdIn.close();
        stdOut.close();
    }
}
