package ch08;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
 */
public class Q01 {
    static int n;
    static String answer = "NO";
    static int[] ch, nums;

    public static void main(String[] args) throws IOException {
        Q01 main = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(stdIn.readLine());
        ch = new int[n + 1];
        nums = new int[n + 1];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 1; i <= n; i++) nums[i] = Integer.parseInt(st.nextToken());
        main.DFS(1);

        stdOut.write(answer);
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }

    public void DFS(int L) {
        if (L == n) {
            int cs = 0;
            int ucs = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) cs += nums[i];
                else ucs += nums[i];
            }
            if (cs == ucs) {
                answer = "YES";
                return;
            }
        } else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }
}
