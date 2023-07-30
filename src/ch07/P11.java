package ch07;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 11. 경로 탐색(인접행렬)
 */
public class P11 {
    static int[][] graph;
    static int[] ch;
    static int n, m, answer;

    public static void main(String[] args) throws IOException {
        P11 main = new P11();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        ch[1] = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
        }

        main.DFS(1);
        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    public void DFS(int v) {
        if (v == 5) answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    System.out.println("graph[" + v + "][" + i + "] = " + graph[v][i]);
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }
}
