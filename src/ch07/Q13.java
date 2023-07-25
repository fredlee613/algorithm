package ch07;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 12. 그래프 최단거리(BFS)
 */
public class Q13 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        Q13 main = new Q13();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        ch[1] = 1;

        stdOut.write(main.bfs(1));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    public String bfs(int v) {
        String answer = "";
        int L = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                dist[cur] = L;
                for (Integer nv : graph.get(cur)) {
                    if (ch[nv] == 0) {
                        ch[nv] = 1;
                        q.offer(nv);
                    }
                }
            }
            L++;
        }
        for (int i = 2; i <= n; i++) {
            answer += i + " : " + dist[i];
            if (i != n) answer += "\n";
        }

        return answer;
    }
}
