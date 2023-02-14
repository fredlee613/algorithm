package ch01;

import java.io.*;

/**
 * 12. 암호
 */
public class Q12 {
    String solution(int count, String input) {
        String answer = "";
        for (int i = 0; i < count; i++) {
            String tmp = input.substring(7 * i, 7 *(i+1));
            tmp = tmp.replace('#', '1').replace('*', '0');
            int num = 0;
            for (int j = 0; j < tmp.length(); j++) {
                num = num * 2 + Character.getNumericValue(tmp.charAt(j));
            }
            answer += (char) num;
        }
        return answer.toUpperCase();
    }

    public static void main(String[] args) throws IOException {
        Q12 q12 = new Q12();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q12.solution(Integer.parseInt(stdIn.readLine()), stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
