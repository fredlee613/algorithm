package ch02;

import java.io.*;

/**
 * 4. 피보나치 수열
 */

public class Q04 {
    String solution(int count) {
        String answer = "1 1 2 ";
        int m_two = 1;
        int m_one = 2;
        for (int i = 3; i < count; i++) {
            int tmp = m_one + m_two;
            if (i < count - 1) {
                answer += tmp + " ";
            } else answer += tmp;
            m_two = m_one;
            m_one = tmp;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q04 q04 = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q04.solution(Integer.parseInt(stdIn.readLine())));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
