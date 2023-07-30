package ch07;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 11. 경로 탐색(인접리스트)
 */
public class P11List {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;
    static int n, m, answer;

    public static void main(String[] args) throws IOException {
        P11List main = new P11List();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        ch = new int[n + 1];
        ch[1] = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
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
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }
}
