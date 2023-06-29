package ch08;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 4. 중복순열
 */
public class Q04 {
    static int answer = Integer.MAX_VALUE;
    static int[] usedCoins;
    static int[] coins;
    static int n, m, maxCount;

    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(stdIn.readLine());
        coins = new int[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(stdIn.readLine());
        maxCount = m / coins[0] + 1;
        usedCoins = new int[maxCount];
        main.DFS(0);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    private void DFS(int L) {
        if (L == maxCount) {
            int sum = 0;
            int cnt = 0;
            for (int x : usedCoins) {
                if (x != 0) {
                    sum += x;
                    cnt++;
                }
            }
            System.out.println("usedCoins = " + Arrays.toString(usedCoins));
            if (sum == m) {
                System.out.println("usedCoins = " + Arrays.toString(usedCoins));
                answer = Math.min(answer, cnt);
            }
        } else {
            for (int i = 0; i < n; i++) {
                usedCoins[L] = i+1;
                DFS(L + 1);
            }
        }
    }
}
