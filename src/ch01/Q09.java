package ch01;

import java.io.*;

/**
 * 9. 숫자만 추출
 */
public class Q09 {
    String solution(String input) {
        input = input.replaceAll("[^0-9]", "");
        int answer = Integer.parseInt(input);
        return String.valueOf(answer);
    }

    String solution_1(String input) {
        input = input.replaceAll("[^0-9]", "");
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            answer = 10 * answer + Character.getNumericValue(input.charAt(i));
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q09 q09 = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q09.solution_1(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
