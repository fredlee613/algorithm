package ch01;

import java.io.*;

/**
 * 3. 문장 속 단어
 */
public class Q03 {
    String solution(String input) {
        String answer = "";
        int ls = 0;
        while (input.indexOf(' ') > 0) {
            String word = input.substring(ls, input.indexOf(' '));
            if (word.length() > answer.length()) answer = word;
            input = input.substring(input.indexOf(' ')+1);
        }
        if (input.length() > answer.length()) answer = input;
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q03 q03 = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q03.solution(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
