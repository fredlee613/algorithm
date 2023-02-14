package ch01;

import java.io.*;

/**
 * 8. 유효한 팰린드롬
 */
public class Q08 {
    String solution(String input) {
        String answer = "YES";

        input = input.replaceAll("[^A-Za-z0-9]", "");
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
        Q08 q08 = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q08.solution(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
