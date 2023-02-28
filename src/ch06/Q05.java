package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 5. 중복 확인
 */
public class Q05 {
    String solution(int n, int[] arr) {
        String answer = "U";

        for (int x = 0; x < n-1; x++) {
            for (int y = 0; y < n - x - 1; y++) {
                if (arr[y] > arr[y + 1]) {
                    if (arr[y] == arr[y+1]) return "D";
                    int tmp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = tmp;
                }
            }
        }

        for (int x = 0; x < n - 1; x++) {
            if (arr[x] == arr[x + 1]) {
                answer = "D";
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q05 q05 = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(q05.solution(n, arr));
        stdIn.close();
        stdOut.close();
    }
}
