package ch03;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 5. 연속된 자연수의 합
 */
public class P05 {
    public static void main(String[] args) throws IOException {
        P05 main = new P05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());

        stdOut.write(main.solution(n));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String solution(int n) {
        int cnt = 0, lt = 0, sum= 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i+1;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == n) cnt++;
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) cnt++;
            }
        }
        return String.valueOf(cnt - 1);
    }
}
