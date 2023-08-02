package ch08;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 9. 조합 구하기
 */
public class Q09 {
    static int n, m;
    static int[] ch, combination;
    static String answer = "";

    void DFS(int L, int S) {
        if (L == m) {
            for (int x : combination) {
                answer += x + " ";
            }
            answer += "\n";
        } else {
            for (int i = S; i <= n; i++) {
                combination[L] = i;
                DFS(L + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Q09 main = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combination = new int[m];


        main.DFS(0, 1);

        stdOut.write(answer);
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
