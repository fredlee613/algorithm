package ch01;

import java.io.*;

/**
 * 7. 회문 문자열
 */
public class Q07 {
    String solution(String input) {
        String answer = "YES";
        int ls  = 0;
        int rs = input.length() - 1;
        char[] arr = input.toUpperCase().toCharArray();
        while (ls < rs) {
            if (arr[ls] != arr[rs]) {
                answer = "NO";
                break;
            }
            ls++;
            rs--;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q07 q07 = new Q07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q07.solution(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
