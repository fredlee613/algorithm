package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. Least Recently Used
 */
public class Q04 {
    String solution(int s, int n, int[] arr) {
        String answer = "";
        int[] cache = new int[s];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) if (x == cache[i]) pos = i;
            if (pos == -1) {
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }

        for (int i = 0; i < s; i++) {
            if (i < s - 1) answer += cache[i] + " ";
            else answer += String.valueOf(cache[i]);
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
