package ch06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 9. 뮤직비디오(결정알고리즘)
 */
public class P09 {
    public static void main(String[] args) throws IOException {
        P09 main = new P09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.makingMusicVideos(n, m, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String makingMusicVideos(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(mid, arr) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }


        return String.valueOf(answer);
    }

    int count(int m, int[] arr) {
        int sum = 0, cnt = 1;
        for (int x : arr) {
            if (sum + x > m) {
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }
}
