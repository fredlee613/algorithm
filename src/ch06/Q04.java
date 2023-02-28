package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. Least Recently Used
 */
public class Q04 {
    String solution(int s, int n, int[] arr) {
        String answer = "";
        int[] work = new int[s];

        for (int x = 0; x < n; x++) {
            int job = arr[x];
            int idx = 20;
            for (int y = 0; y < s; y++) if (work[y] == job) idx = y;

            if (idx > 10) { // cache miss
                for (int y = s - 1; y >= 1; y--) work[y] = work[y - 1];
                work[0] = job;
            } else {  // cache hit
                for (int y = idx; y >= 1; y--) work[y] = work[y - 1];
                work[0] = job;
            }
        }

        for (int i = 0; i < s; i++) {
            if (i != s - 1) answer += work[i] + " ";
            else answer += work[i];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q04 q04 = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(stdIn.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q04.solution(s, n, arr));
        stdIn.close();
        stdOut.close();
    }
}
