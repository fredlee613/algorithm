package ch02;

import java.io.*;

/**
 * 5. 소수(에라토스테네스 체)
 */

public class Q05 {
    String solution(int count) {
        int answer = 0;
        int[] ch = new int[count + 1];
        for (int i = 2; i <= count; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= count; j = j+i) {
                    ch[j] = 1;
                }
            }
        }

        return String.valueOf(answer);
    }
    public static void main(String[] args) throws IOException {
        Q05 q05 = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q05.solution(Integer.parseInt(stdIn.readLine())));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
