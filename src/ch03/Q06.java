package ch03;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 6. 최대 길이 연속부분수열
 */
public class Q06 {
    String solution(int size, int length, int[] arr) {
        int answer = 0, lt = 0, cnt = 0;

        for (int rt = 0; rt < size; rt++) {
            if (arr[rt] == 0) cnt++;
            while (cnt > length) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q06 q06 = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        int size = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] list = new int[size];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        stdOut.write(q06.solution(size, count, list));

        stdIn.close();
        stdOut.close();
    }
}
