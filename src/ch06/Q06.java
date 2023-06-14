package ch06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 6. 장난꾸러기
 */
public class Q06 {
    String solution(int n, int[] arr) {
        String answer = "";
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) answer += (i+1) + " ";
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q06 q06 = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q06.solution(n, arr));
        stdIn.close();
        stdOut.close();
    }
}
