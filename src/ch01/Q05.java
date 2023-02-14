package ch01;

import java.io.*;

/**
 * 5. 특정 문자 뒤집기
 */
public class Q05 {
    String solution(String input) {
        int ls = 0;
        int rs = input.length() - 1;
        char[] arr = input.toCharArray();
        while (ls < rs) {
            if (Character.isAlphabetic(arr[ls])) {
//                System.out.println("arr[ls] = " + arr[ls] + ", arr[rs] = " + arr[rs]);
                if (Character.isAlphabetic(arr[rs])) {
//                    System.out.println("change!!");
                    char tmp = arr[ls];
                    arr[ls] = arr[rs];
                    arr[rs] = tmp;
                    ls++;
                }
                rs--;
            } else {
                ls++;
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) throws IOException {
        Q05 q05 = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q05.solution(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
