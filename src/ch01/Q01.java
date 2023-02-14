package ch01;

import java.io.*;

/**
 * 1. 문자 찾기
 */
public class Q01 {
    int solution(String word, String letter) {
        int answer = 0;
        char[] arr = word.toLowerCase().toCharArray();
        for (char c : arr) {
            boolean result = c == letter.toLowerCase().charAt(0);
            if (result == true) answer++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q01 q01 = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(String.valueOf(q01.solution(stdIn.readLine(), stdIn.readLine())));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
