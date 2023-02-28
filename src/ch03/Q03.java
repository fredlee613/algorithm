package ch03;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 최대 매출
 */
public class Q03 {
    String solution(int size, int count, int[] list) {
        int answer = 0;
        for (int x = 0; x < size - count; x++) {
            int tmp = 0;
            for (int y = 0; y < count; y++) {
                tmp += list[x + y];
            }
            if (tmp > answer) answer = tmp;
        }
        return String.valueOf(answer);
    }

    String solution_final(int size, int count, int[] list) {
        int answer = 0;
        for (int i = 0; i < count; i++) {
            answer += list[i];
        }
        int tmp = answer;
        for (int x = count; x < size - count; x++) {
            tmp = tmp + list[x] - list[x - count];
            if (tmp > answer) answer = tmp;
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q03 q03 = new Q03();
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

        stdOut.write(q03.solution_final(size, count, list));

        stdIn.close();
        stdOut.close();
    }
}
