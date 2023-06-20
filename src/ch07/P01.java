package ch07;

/**
 * 1. 재귀함수
 */
public class P01 {
    public void Recursive(int n) {
        if (n == 0);
        else {
            System.out.println(n);
            Recursive(n -1);
        }
    }

    public static void main(String[] args) {
        P01 main = new P01();
        main.Recursive(3);
    }
}
