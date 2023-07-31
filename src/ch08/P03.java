package ch08;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 최대점수 구하기(DFS)
 */
public class P03 {
    static int n, m, answer = 0;
    static int[] point, time, ch;

    void DFS(int L) {
        if (L == n + 1) {
            int sumOfPoints = 0;
            int sumOfTime = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    sumOfPoints += point[i];
                    sumOfTime += time[i];
                }
            }
            if (sumOfTime <= m) answer = Math.max(answer, sumOfPoints);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    void DFS_answer(int L, int sumOfPoints, int sumOfTime, int[] point, int[] time) {
        if (sumOfTime > m) return;
        if (L == n + 1) answer = Math.max(answer, sumOfPoints);
        else {
            DFS_answer(L + 1, sumOfPoints + point[L], sumOfTime + time[L], point, time);
            DFS_answer(L + 1, sumOfPoints, sumOfTime, point, time);
        }
    }

    public static void main(String[] args) throws IOException {
        P03 main = new P03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        point = new int[n + 1];
        time = new int[n + 1];
        ch = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            point[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

//        main.DFS(1);
        main.DFS_answer(1, 0, 0, point, time);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

}
