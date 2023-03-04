package ch07;

import java.io.*;

/**
 * 1. 재귀함수
 */

public class Q01 {
    public void Recursive(int n) {
        if (n == 0) return;
        else {
            System.out.println("n = " + n);
            Recursive(n - 1);
        }
    }

    public static void main(String[] args) {
        Q01 q01 = new Q01();
        q01.Recursive(3);
    }
}
