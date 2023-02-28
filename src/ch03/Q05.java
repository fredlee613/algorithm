package ch03;

import java.io.*;

/**
 * 5. 연속된 자연수의 합
 */
public class Q05 {
    String solution(int num) {
        int answer = 0;
        int sum = 1;
        int lt = 1;
        for (int rt = 2; rt < num; rt++) {
            sum += rt;
            if (sum == num) answer++;
            while (sum >= num) {
                sum -= lt++;
                if (sum == num) answer++;
            }
        }
        return String.valueOf(answer);
    }

    String solution_two_pointer(int num) {
        int answer = 0, lt = 0, sum = 0;
        int count = num / 2 + 1;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) arr[i] =i + 1;
        for (int rt = 0; rt < count; rt++) {
            sum += arr[rt];
            if (sum == num) answer++;
            while (sum >= num) {
                sum -= arr[lt++];
                if (sum == num) answer++;
            }
        }
            return String.valueOf(answer);
    }
    String solution_math(int num) {
        int answer = 0, cnt = 1;
        num--;
        while (num > 0) {
            cnt++;
            num = num - cnt;
            if (num % cnt == 0) answer++;
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q05 q05 = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(q05.solution_math(Integer.parseInt(stdIn.readLine())));

        stdIn.close();
        stdOut.close();
    }
}
