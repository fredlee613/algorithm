package ch06;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 6. 장난꾸러기
 */
public class Q06 {
    String solution(int n, int[] arr) {
        String answer = "";
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("i +1 = " + i +1);
                answer += (i+1) + " ";
                break;
            }

        }
        for (int i = n - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("i +1 = " + i +1);
                answer += (i+1);
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q06 q06 = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q06.solution(n, arr));
        stdIn.close();
        stdOut.close();
    }
}
