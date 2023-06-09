package ch03;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. 연속 부분수열
 */
public class P04 {
    public static void main(String[] args) throws IOException {
        P04 main = new P04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.solution(n, k, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String solution(int n, int k, int[] arr) {
        int cnt = 0, lt = 0, sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == k) cnt++;
            while (sum >= k) {
                sum -= arr[lt++];
                if (sum == k) cnt++;
            }
        }

        return String.valueOf(cnt);
    }
}
