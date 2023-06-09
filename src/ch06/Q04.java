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
        for (int x = 0; x < n; x++) {
            int tmp = arr[x], y;
            boolean hit = false;
            for (y = 0; y < s; y++) {
                if (cache[y] == tmp) {
                    hit = true;
                    break;
                }
            }
            if (hit) for (int z = y; z >= 1; z--) cache[z] = cache[z - 1];
            else for (int z = s - 1; z >= 1; z--) cache[z] = cache[z - 1];
            cache[0] = tmp;
        }

        for (int x : cache) answer += x + " ";

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
