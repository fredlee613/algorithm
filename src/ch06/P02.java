package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2. 버블정렬
 */
public class P02 {
    public static void main(String[] args) throws IOException {
        P02 main = new P02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.bubbleSort(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String bubbleSort(int n, int[] arr) {
        String answer = "";
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - x - 1; y++) {
                if (arr[y] > arr[y + 1]) {
                    int tmp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i < n-1) answer += arr[i] + " ";
            else answer += String.valueOf(arr[i]);
        }
        return answer;
    }
}
