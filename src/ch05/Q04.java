package ch05;

import java.io.*;
import java.util.Stack;

/**
 * 4. 후위식 연산(postfix)
 */
public class Q04 {
    String solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) stack.push(Character.getNumericValue(x));
//            if (Character.isDigit(x)) stack.push(x - 48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') stack.push(lt + rt);
                else if (x == '-') stack.push(lt - rt);
                else if (x == '*') stack.push(lt * rt);
                else if (x == '/') stack.push(lt / rt);
            }
        }
        return String.valueOf(stack.get(0));
    }
    public static void main(String[] args) throws IOException {
        Q04 q04 = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q04.solution(stdIn.readLine()));
        stdIn.close();
        stdOut.close();
    }
}
