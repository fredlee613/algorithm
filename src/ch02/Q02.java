package ch02;

import java.io.*;

/**
 * 2. 보이는 학생
 */

public class Q02 {
    String solution(int count, String input) {
        String[] arr = input.split(" ");
        int answer = 0;
        int tallest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tmp = Integer.parseInt(arr[i]);
            if (tmp > tallest) {
                answer++;
                tallest = tmp;
            }
        }

        return String.valueOf(answer);
    }
    public static void main(String[] args) throws IOException {
        Q02 q01 = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(stdIn.readLine());
        stdOut.write(q01.solution(count, stdIn.readLine()));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
