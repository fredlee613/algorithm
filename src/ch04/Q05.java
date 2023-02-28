package ch04;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 5. K번째 큰 수
 */
public class Q05 {
    String solution(int num1, int num2, int[] arr) {
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int x = 0; x < num1; x++) {
            for (int y = x + 1; y < num1; y++) {
                for (int z = y + 1; z < num1; z++) {
                    int sum = arr[x] + arr[y] + arr[z];
                    set.add(sum);
                }
            }
        }
        int cnt = 0;
        for (int x : set) {
            cnt++;
            if (cnt == num2) return String.valueOf(x);
        }
        return String.valueOf(answer);
    }


    public static void main(String[] args) throws IOException {
        Q05 q05 = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[num1];
        for (int i = 0; i < num1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stdOut.write(q05.solution(num1, num2, arr));

        stdIn.close();
        stdOut.close();
    }
}
