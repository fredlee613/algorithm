package ch07;

/**
 * 3. 팩토리얼
 */
public class P03 {

    int Factorial(int n) {
        if (n == 1) return 1;
        return n * Factorial(n - 1);
    }

    public static void main(String[] args) {
        P03 main = new P03();
        int factorial = main.Factorial(5);
        System.out.println("factorial = " + factorial);
    }
}
