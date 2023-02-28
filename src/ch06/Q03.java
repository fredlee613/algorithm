package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 삽입 정렬
 */
public class Q03 {
    String solution(int n, int[] arr) {
        String answer = "";
        for (int x = 1; x < n; x++) {
            int tmp = arr[x], y;
            for (y = x - 1; y >= 0; y--) {
                if (arr[y] > tmp) arr[y + 1] = arr[y];
                else break;
            }

            arr[y + 1] = tmp;
        }
        for (int i = 0; i < n; i++) {
            if (i != n - 1) answer += arr[i] + " ";
            else answer += arr[i];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q03 q03 = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q03.solution(n, arr));
        stdIn.close();
        stdOut.close();
    }
}
