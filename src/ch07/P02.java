package ch07;

/**
 * 2. 재귀함수를 이용한 이진수 출력
 */
public class P02 {

    void PrintBinaryNumber(int n) {
        if (n ==0) return;
        else {
            PrintBinaryNumber(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        P02 main = new P02();
        main.PrintBinaryNumber(11);
    }
}
