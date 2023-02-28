package ch05;

import java.io.*;
import java.util.Stack;

/**
 * 1. 올바른 괄호
 */
public class Q01 {
    String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q01 q01 = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q01.solution(stdIn.readLine()));
        stdIn.close();
        stdOut.close();
    }
}
