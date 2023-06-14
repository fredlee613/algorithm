package ch06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 6. 장난꾸러기
 */
public class P06 {
    public static void main(String[] args) throws IOException {
        P06 main = new P06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.findTricksters(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String findTricksters(int n, int[] arr) {
        String answer = "";
        int tmp = 0;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                tmp = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[tmp]) {
                answer += (i + 1) + " " + (tmp + 1);
                break;
            }
        }

        return answer;
    }
}
