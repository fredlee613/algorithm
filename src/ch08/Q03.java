package ch08;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 3. 최대점수 구하기(DFS)
 */
public class Q03 {
    static int n, m;
    static int answer = 0;
    static int[] ch;
    static ArrayList<Problem> problems;

    static class Problem {
        int point;
        int time;

        public Problem(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        problems = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            problems.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        main.DFS(1);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }

    public void DFS(int L) {
        if (L == n + 1) {
            int sumOfTime = 0;
            int sumOfPoints = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i + 1] == 1) {
                    Problem cur = problems.get(i);
                    sumOfTime += cur.time;
                    sumOfPoints += cur.point;
                }
            }
            if (sumOfTime <= m) answer = Math.max(answer, sumOfPoints);
        } else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }
}
