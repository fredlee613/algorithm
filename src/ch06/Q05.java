package ch06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 5. 중복 확인
 */
public class Q05 {
    String solution(int n, int[] arr) {
        String answer = "U";
//        Arrays.sort(arr);

//        for (int x = 0; x < n; x++) {
//            for (int y = 0; y < n - 1 - x; y++) {
//                if (arr[y + 1] < arr[y]) {
//                    int tmp = arr[y];
//                    arr[y] = arr[y+1];
//                    arr[y + 1] = tmp;
//                }
//            }
//        }

        for (int x = 1; x < n; x++) {
            int tmp = arr[x], y;
            for (y = x - 1; y >= 0; y--) {
                if (arr[y] > tmp) arr[y + 1] = arr[y];
                else break;
            }
            arr[y+1] = tmp;
        }

        for (int x = 0; x < n - 1; x++) {
            if (arr[x + 1] == arr[x]) {
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
