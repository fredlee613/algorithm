package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 4. 피보나치 수열
 */

public class Q04 {
    static int[] fibo;
    public int FibonacciSequence(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = FibonacciSequence(n - 1) + FibonacciSequence(n - 2);
    }
    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdIn.readLine());
        fibo = new int[n + 1];
        main.FibonacciSequence(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
