package ch03;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 두 배열 합치기
 */
public class P01 {
    public static void main(String[] args) throws IOException {
        P01 main = new P01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] n_arr = new int[n];
        for (int i = 0; i < n; i++) n_arr[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int[] m_arr = new int[m];
        for (int i = 0; i < m; i++) m_arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.solution(n, m, n_arr, m_arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String solution(int n, int m, int[] n_arr, int[] m_arr) {
        String answer = "";
        int rt = 0;
        for (int lt = 0; lt < n; lt++) {
            while (rt < m && m_arr[rt] < n_arr[lt]) {
                answer += m_arr[rt] + " ";
                rt++;
            }
            answer += n_arr[lt] + " ";
        }
        for (int i = rt; i < m; i++) {
            answer += m_arr[i] + " ";
        }
        return answer;
    }
}
