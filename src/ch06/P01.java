package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 선택정렬
 */
public class P01 {
    public static void main(String[] args) throws IOException {
        P01 main = new P01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.selectionSort(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String selectionSort(int n, int[] arr) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            int smallest = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (arr[j] < smallest) {
                    smallest = arr[j];
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
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
