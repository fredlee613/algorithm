package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 6. 부분집합 구하기(DFS)
 */
public class P06 {
    static int n;
    static int[] chArr;
    public void PrintAllSubsets(int L) {
        if (L == 0) {
            for (int i = 1; i <= n; i++) {
                if (chArr[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            chArr[L] = 1;
            PrintAllSubsets(L - 1);
            chArr[L] = 0;
            PrintAllSubsets(L - 1);
        }

    }

    public static void main(String[] args) throws IOException{
        P06 main = new P06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(stdIn.readLine());
        chArr = new int[n + 1];
        main.PrintAllSubsets(n);
        stdIn.close();

    }
}
