package ch08;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 5. 동전교환
 */
public class Q05 {
    static int n, m;
    static int[] coins;
    static int answer = Integer.MAX_VALUE;

    void DFS(int L, int sum) {
//        System.out.println("sum = " + sum);
        if (sum > m) return;
        if (L >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, L);
//            System.out.println("sum = " + sum + ", L = " + L + ", answer = " + answer);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + coins[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(stdIn.readLine());
        coins = new int[n+1];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = n - 1; i >= 0; i--) coins[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(stdIn.readLine());


        main.DFS(0, 0);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        
        stdOut.close();
        stdIn.close();
    }
}
