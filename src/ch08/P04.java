package ch08;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. 중복순열
 */
public class P04 {
    static int n, m;
    static int[] arr;
    static String answer = "";

    void DFS(int L) {
        if (L == m + 1) {
            for (int i = 1; i < n; i++) answer += arr[i] + " ";
            answer += "\n";
        } else {
            for (int i = 1; i <= m + 1; i++) {
                arr[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        P04 main = new P04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        main.DFS(1);

        stdOut.write(answer);
        stdOut.flush();
        
        stdOut.close();
        stdIn.close();
    }
}
