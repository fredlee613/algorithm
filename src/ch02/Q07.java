package ch02;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * 7. 점수계산
 */

public class Q07 {
    String solution(int count, String input) {
        String answer = "";

        String[] arr = input.split(" ");
        Integer[] intArr = new Integer[arr.length];
        Integer[] tmp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        Integer[] sortArr = intArr.clone();
        Arrays.sort(sortArr, Collections.reverseOrder());

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < sortArr.length; j++) {
                if (intArr[i] == sortArr[j]) {
                    tmp[i] = j+1;
                    break;
                }
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            if (i < tmp.length - 1) answer += tmp[i] + " ";
            else answer += String.valueOf(tmp[i]);

        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q07 q07 = new Q07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q07.solution(Integer.parseInt(stdIn.readLine()), stdIn.readLine()));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
