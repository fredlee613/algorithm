package ch08;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 6. 순열 구하기
 */
public class Q06 {
    static int n, m;
    static int[] arr, pm, ch;
    static String answer = "";

    void DFS(int L) {
        if (L == m) {
            for (int i = 0; i < m; i++) answer += pm[i] + " ";
            answer += "\n";
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q06 main = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ch = new int[n];
        pm = new int[m];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        main.DFS(0);

        stdOut.write(answer);
        stdOut.flush();
        
        stdOut.close();
        stdIn.close();
    }
}
