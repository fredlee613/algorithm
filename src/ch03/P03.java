package ch03;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 최대 매출
 */
public class P03 {
    public static void main(String[] args) throws IOException {
        P03 main = new P03();
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
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        int answer = sum;
        for (int i = 0; i < n-k; i++)  {
            sum = sum - arr[i] + arr[i + k];
            answer = Math.max(answer, sum);
        }

        return String.valueOf(answer);
    }
}
