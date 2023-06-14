package ch06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 5. 중복 확인
 */
public class P05 {
    public static void main(String[] args) throws IOException {
        P05 main = new P05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.findDuplicates(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String findDuplicates(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for (int x = 0; x < n; x++) {
            for (int y = x; y < n - 1; y++) {
                if (arr[y] == arr[y + 1]) return "D";
            }
        }
        return answer;
    }
}
