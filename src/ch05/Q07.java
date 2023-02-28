package ch05;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 7. 교육과정 설계
 */
public class Q07 {
    String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for (char x : need.toCharArray()) q.offer(x);
        for (char x : plan.toCharArray()) {
            if (q.contains(x)) {
                if (x != q.poll()) return "NO";
            }
        }
        if (!q.isEmpty()) answer = "NO";
        return answer;
    }

    String solution_me(String order, String classes) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for (char x : order.toCharArray()) q.offer(x);
        for (char x : classes.toCharArray()) {
            if (order.contains(Character.toString(x))) {
                if (q.peek() != x) {
                    System.out.println("q.peek() = " + q.peek() + ", x = " + x);
                    answer = "NO";
                    break;
                } else q.poll();
            }
        }
        if (q.size() != 0) answer = "NO";
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q07 q07 = new Q07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        stdOut.write(q07.solution(stdIn.readLine(), stdIn.readLine()));
        stdIn.close();
        stdOut.close();
    }
}
