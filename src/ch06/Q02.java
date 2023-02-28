package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2. 버블 정렬
 */
public class Q02 {
    String solution(int n, int[] arr) {
        String answer = "";
        for (int x = 0; x < n - 1; x++) {
            for (int y = 0; y < n - x - 1; y++) {
                if (arr[y] > arr[y+1]) {
                    int tmp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = tmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != n - 1) answer += arr[i] + " ";
            else answer += arr[i];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q02 q02 = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q02.solution(n, arr));
        stdIn.close();
        stdOut.close();
    }
}
