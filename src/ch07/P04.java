package ch07;

import java.util.Arrays;

/**
 * 4. 피보나치 수열
 */
public class P04 {
    static int[] arr;

    int Fibonacci(int n) {
        if (arr[n] > 0) return arr[n];
        if (n == 1) return arr[n] = 1;
        else if (n == 2) return arr[n] = 1;
        else return arr[n] = Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    public static void main(String[] args) {
        P04 main = new P04();
        int n = 45;
        arr = new int[n + 1];
        main.Fibonacci(n);
        for (int i = 1; i <=  n; i++) System.out.print(arr[i] + " ");
    }
}
