package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 선택 정렬
 */
public class Q01 {
    String solution(int num, int[] arr) {
        String answer = "";
        for (int x = 0; x < num; x++) {
            int idx = x;
            for (int y = x + 1; y < num; y++) if (arr[y] < arr[idx]) idx = y;
            int tmp = arr[x];
            arr[x] = arr[idx];
            arr[idx] = tmp;
        }
        for (int x : arr) {
            answer += String.valueOf(x) + " ";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q01 q01 = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int num = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q01.solution(num, arr));
        stdIn.close();
        stdOut.close();
    }
}
