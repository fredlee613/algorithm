package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 선택 정렬
 */
public class Q01 {
    String solution(int n, int[] arr) {
        String answer = "";
        for (int x = 0; x < n - 1; x++) {
            int idx = x;
            for (int y = x + 1; y < n - 1; y++) {
                if (arr[y] < arr[idx]) idx = y;
            }
            int tmp = arr[x];
            arr[x] = arr[idx];
            arr[idx] = tmp;
        }
        for (int i = 0; i < n; i++) {
            if (i != n - 1) answer += arr[i] + " ";
            else answer += arr[i];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q01 q01 = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q01.solution(n, arr));
        stdIn.close();
        stdOut.close();
    }
}
