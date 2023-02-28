package ch05;

import java.io.*;
import java.util.Stack;

/**
 * 5. 쇠막대기
 */
public class Q05 {
    String solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(str.charAt(i));
            else {
                stack.pop();
                if (str.charAt(i - 1) == '(') answer += stack.size();
                else answer += 1;
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q05 q05 = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q05.solution(stdIn.readLine()));
        stdIn.close();
        stdOut.close();
    }
}
