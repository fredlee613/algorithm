package ch02;

import java.io.*;

/**
 * 6. 뒤집은 소수
 */

public class Q06 {
    String solution(int count, String[] arr) {
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            int num = 0;
            char[] charArr = arr[i].toCharArray();
            for (int j = charArr.length - 1; j >= 0; j--) {
                num = num * 10 + Character.getNumericValue(charArr[j]);
            }
            int cursor = 2;
            boolean flag = true;
            while (cursor < num) {
                if (num % cursor == 0) {
                    flag = false;
                    break;
                }
                cursor++;
            }
            if (flag && num >= 2) {
                if (i < arr.length - 1) answer += num + " ";
                else answer += num;
            }

        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q06 q05 = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q05.solution(Integer.parseInt(stdIn.readLine()), stdIn.readLine().split(" ")));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
