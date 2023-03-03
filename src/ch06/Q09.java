package ch06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 9. 뮤직비디오(결정알고리즘)
 */
public class Q09 {
    public int count(int[] arr, int capacity) {
        int count = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                count++;
                sum = x;
            } else sum += x;
        }
        return count;
    }


    String solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q09 q09 = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q09.solution(n, m, arr));
        stdIn.close();
        stdOut.close();
    }
}
