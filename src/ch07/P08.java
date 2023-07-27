package ch07;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 8. 송아지 찾기(BFS : 상태트리탐색)
 */

public class P08 {
    static int[] chArr;
    static int[] directions = {1, -1, 5};

    int DFS(int s, int e) {
        int answer = 1;
        chArr = new int[10001];
        Queue<Integer> queue = new LinkedList<>();
        chArr[s] = 1;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currentLocation = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int nextLocation = currentLocation + directions[j];
                    if (nextLocation == e) return answer;
                    if (nextLocation >= 1 && nextLocation <= 10000 && chArr[nextLocation] == 0) {
                        queue.offer(nextLocation);
                        chArr[nextLocation] = 1;
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        P08 main = new P08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        stdOut.write(String.valueOf(main.DFS(s, e)));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
