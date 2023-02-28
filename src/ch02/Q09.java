package ch02;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 9. 격자판 최대합
 */

public class Q09 {
    String solution(int count, int[][] input) {
        int answer = 0;
        int horizontal = 0;
        int vertical = 0;
        int diagonal = 0;
        int revDiagonal = 0;

        for (int i = 0; i < count; i++) {
            int tmpH = 0;
            int tmpV = 0;
            for (int j = 0; j < count; j++) {
                tmpH += input[i][j];
                tmpV += input[j][i];
                if (i == j) diagonal += input[i][j];
                if (i+j == 4) revDiagonal += input[i][j];
            }
            if (tmpH > horizontal) horizontal = tmpH;
            if (tmpV > vertical) vertical = tmpV;
        }

        int[] candidates = {horizontal, vertical, diagonal, revDiagonal};
        answer = horizontal;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > answer) answer = candidates[i];
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q09 q09 = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(stdIn.readLine());
        int[][] list = new int[count][count];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < count; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        stdOut.write(q09.solution(count, list));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
