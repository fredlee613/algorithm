package ch01;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 10. 가장 짧은 문자거리
 */
public class Q10 {
    int[] solution(String word, String letter) {
        int[] answer = new int[word.length()];
        int cursor = 100;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == letter.charAt(0)) {
                cursor = 0;
                answer[i] = cursor;
            } else {
                cursor++;
                answer[i] = cursor;
            }
        }
        cursor = 100;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == letter.charAt(0)) {
                cursor = 0;
                answer[i] = cursor;
            } else {
                cursor++;
                if (cursor < answer[i]) answer[i] = cursor;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q10 q10 = new Q10();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int[] answer = q10.solution(st.nextToken(), st.nextToken());
        for (int i = 0; i < answer.length; i++) {
            if (i < answer.length - 1) stdOut.write(String.valueOf(answer[i])+" ");
            else stdOut.write(String.valueOf(answer[i]));
        }
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
