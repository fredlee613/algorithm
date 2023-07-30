package ch07;

import java.io.*;
import java.util.*;

/**
 * 12. 그래프 최단거리(BFS)
 */
public class P12 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        P12 main = new P12();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }

        main.BFS(1);

        String answer = "";
        for (int i = 2; i <= n; i++) {
            answer += (i + " : " + dist[i]);
            if (i != n) answer += "\n";
        }

        stdOut.write(answer);
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dist[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int currentQueue = queue.poll();
            for (int nv : graph.get(currentQueue)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dist[nv] = dist[currentQueue] + 1;
                }
            }
        }
    }
}
