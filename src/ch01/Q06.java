package ch01;

import java.io.*;

/**
 * 6. 중복문자제거
 */
public class Q06 {
    String solution(String input) {
        String answer = "";
        char[] arr = input.toCharArray();
        for (char c : arr) {
            if (!answer.contains(Character.toString(c))) {
                answer += c;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q06 q06 = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q06.solution(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
