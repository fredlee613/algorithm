package ch07;

import java.io.*;

/**
 * 6. 부분집합 구하기(DFS)
 */
public class Q06 {
    static int n;
    static int[] ch;
    public void PrintAllSubsets(int L) {
        if (L == n + 1) {
            String subSet = "";
            for (int i = 1; i < n + 1; i++) {
                if (ch[i] != 0) subSet += i + " ";
            }
            if (subSet != "") System.out.println(subSet);
        } else {
            ch[L] = 1;
            PrintAllSubsets(L + 1);
            ch[L] = 0;
            PrintAllSubsets(L + 1);
        }

    }

    public static void main(String[] args) throws IOException{
        Q06 main = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(stdIn.readLine());
        ch = new int[n + 1];
        main.PrintAllSubsets(1);

        stdIn.close();

    }
}
