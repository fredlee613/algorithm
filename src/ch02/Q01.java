package ch02;

import java.io.*;

/**
 * 1. 큰 수 출력하기
 */

public class Q01 {
    String solution(int count, String input) {
        String[] arr = input.split(" ");
        String answer = "";
        int former = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tmp = Integer.parseInt(arr[i]);
            if (tmp > former) {
                if (i < arr.length - 1) answer += arr[i] + " ";
                else answer += arr[i];
            }
            former = tmp;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q01 q01 = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(stdIn.readLine());
        stdOut.write(q01.solution(count, stdIn.readLine()));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
