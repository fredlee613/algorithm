package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 삽입정렬
 */
public class P03 {
    public static void main(String[] args) throws IOException {
        P03 main = new P03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.isnertionSort(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String isnertionSort(int n, int[] arr) {
        String answer = "";
        for (int x = 0; x < n; x++) {
            int tmp = arr[x], y;
            for (y = x - 1; y >= 0; y--) {
                if (arr[y] > tmp) arr[y + 1] = arr[y];
                else break;
            }
            arr[y + 1] = tmp;
        }
        for (int i = 0; i < n; i++) {
            if (i < n-1) answer += arr[i] + " ";
            else answer += String.valueOf(arr[i]);
        }
        return answer;
    }
}
