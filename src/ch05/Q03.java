package ch05;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 3. 크레인 인형뽑기(카카오)
 */
public class Q03 {
    String solution(int num1, char[][] crane, int num2, int[] move) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int x : move) {
            for (int y = 0; y < num1; y++) {
                if (crane[y][x] != '0') {
                    char tmp = crane[y][x];
                    crane[y][x] = '0';

                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else stack.push(tmp);
                    break;
                }
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q03 q03 = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num1 = Integer.parseInt(stdIn.readLine());
        char[][] crane = new char[num1][num1];
        for (int x = 0; x < num1; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < num1; y++) {
                crane[x][y] = st.nextToken().charAt(0);
            }
        }

        int num2 = Integer.parseInt(stdIn.readLine());
        int[] move = new int[num2];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < num2; i++) {
            move[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        stdOut.write(q03.solution(num1, crane, num2, move));
        stdIn.close();
        stdOut.close();
    }
}
