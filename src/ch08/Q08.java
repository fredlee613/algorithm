package ch08;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 8. 수열 추측하기
 */
public class Q08 {
    static int n, f;
    static int[] b, p, ch;
    static String answer = "";
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combination(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public void DFS(int L, int sum) {
        if (flag) return;
        if (L == n) {
            String tmp = "";
            if (sum == f) {
                for (int x : p) tmp += x + " ";
                tmp += "\n";
                answer = tmp;
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = main.combination(n - 1, i);
        }


        main.DFS(0, 0);

        stdOut.write(answer);
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
