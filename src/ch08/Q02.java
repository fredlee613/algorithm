package ch08;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2. 바둑이 승차(DFS)
 */
public class Q02 {
    static int n, maxWeight;
    static int answer = 0;
    static int[] ch, pups;

    public static void main(String[] args) throws IOException {
        Q02 main = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        maxWeight = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        pups = new int[n + 1];

        for (int i = 1; i <= n; i++) pups[i] = Integer.parseInt(stdIn.readLine());
        main.DFS(1);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }

    public void DFS(int L) {
        if (L == n+1) {
            int tmp = 0;
            for (int i = 1; i <= n; i++) if (ch[i] == 1) tmp += pups[i];
            if (tmp <= maxWeight) answer = Math.max(answer, tmp);
        } else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }
}
