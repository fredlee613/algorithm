package ch01;

import java.io.*;

/**
 * 11. 문자열 압축
 */
public class Q11 {
    String solution(String input) {
        String answer = "" + input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (answer.charAt(answer.length() - 1) == input.charAt(i)) {
                count++;
            } else {
                if (count > 1) {
                    answer += count;
                }
                count = 1;
                answer += input.charAt(i);
            }
        }
        if (count > 1) {
            answer += count;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q11 q11 = new Q11();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q11.solution(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
