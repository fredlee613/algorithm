package ch07;

/**
 * 3. 팩토리얼
 */

public class Q03 {
    public int Factorial(int n) {
        if (n == 1) return 1;
        else return n * Factorial(n - 1);
    }
    public static void main(String[] args) {
        Q03 q01 = new Q03();
        System.out.println("q01.Factorial(5) = " + q01.Factorial(5));
    }
}
