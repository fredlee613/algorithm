package ch08;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2. 바둑이 승차(DFS)
 */
public class P02 {
    static int[] arr, ch;
    static int n, c, answer = 0;

    public static void main(String[] args) throws IOException {
        P02 main = new P02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        ch = new int[n + 1];

        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(stdIn.readLine());

        main.DFS(1);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    void DFS(int L) {
        if (L == n + 1) {
            int sum = 0;
            for (int i = 1; i <= n; i++) if (ch[i] == 1) sum += arr[i];
            if (sum <= c) {
                answer = Math.max(answer, sum);
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

}
