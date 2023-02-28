package ch05;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 6. 공주 구하기
 */
public class Q06 {
    String solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i  <= n; i++) q.offer(i);
        while(!q.isEmpty()) {
            for (int i = 1; i < k; i++) q.offer(q.poll());
            q.poll();
            if (q.size() == 1) answer = q.poll();
        }
        return String.valueOf(answer);
    }

    String solution_me (int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i  <= n; i++) {
            q.offer(i);
        }
        while(q.size() > 1) {
            for (int i = 0; i < k; i++) {
                if (i < k-1) q.offer(q.poll());
                else q.poll();
            }
        }
        return String.valueOf(q.poll());
    }

    public static void main(String[] args) throws IOException {
        Q06 q06 = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(stdIn.readLine());
        stdOut.write(q06.solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        stdIn.close();
        stdOut.close();
    }
}
