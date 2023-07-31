package ch08;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
 */
public class P01 {
    static int[] arr, ch;
    static String answer = "NO";
    static int n, total;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        P01 main = new P01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(stdIn.readLine());
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        arr = new int[n + 1];
        ch = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        total = Arrays.stream(arr).sum();
//        main.DFS(1);
        main.DFS_answer(1, 0, arr);
        stdOut.write(answer);
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    void DFS(int L) {
        if (L == n) {
            int sum_checked = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) sum_checked += arr[i];
            }
            if (sum_checked == total - sum_checked) answer = "YES";
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    void DFS_answer(int L, int sum, int[] arr) {
        if (flag) return;
        if (sum > total / 2) return;
        if (L == n + 1) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS_answer(L + 1, sum + arr[L], arr);
            DFS_answer(L + 1, sum, arr);
        }
    }
}
