package ch01;

import java.io.*;

/**
 * 2. 대소문자 변환
 */
public class Q02 {
    String solution(String input) {
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i])) arr[i] = Character.toLowerCase(arr[i]);
            else arr[i] = Character.toUpperCase(arr[i]);
        }
        return String.valueOf(arr);
    }
    public static void main(String[] args) throws IOException {
        Q02 q02 = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q02.solution(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
