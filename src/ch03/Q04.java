package ch03;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. 연속 부분수열
 */
public class Q04 {
    String solution(int size, int count, int[] list) {
        int answer = 0, sum = 0;
        int lt = 0;

        for (int rt = 0; rt < size; rt++) {
            sum += list[rt];
            if (sum == count) answer++;
            while (sum >= count) {
                sum -= list[lt++];
                if (sum == count) answer++;
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q04 q04 = new Q04();
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

        stdOut.write(q04.solution(size, count, list));

        stdIn.close();
        stdOut.close();
    }
}
