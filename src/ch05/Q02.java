package ch05;

import java.io.*;
import java.util.Stack;

/**
 * 2. 괄호문자제거
 */
public class Q02 {
    String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else if (x == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) answer += x;
            }
        }
        return answer;
    }

    String solution_final(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else stack.push(x);
        }

        for (char x : stack) answer += x;

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q02 q02 = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q02.solution_final(stdIn.readLine()));
        stdIn.close();
        stdOut.close();
    }
}
