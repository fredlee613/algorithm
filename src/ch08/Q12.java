package ch08;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 12. 토마토(BFS)
 */
public class Q12 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] dist;
    static int n, m;
    static Queue<Point> q = new LinkedList<>();
    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void BFS() {
        while (!q.isEmpty()) {
            Point cp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    dist[nx][ny] = dist[cp.x][cp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q12 main = new Q12();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        dist = new int[m][n];

        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < n; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
                if (board[x][y] == 1) q.offer(new Point(x, y));
            }
        }
        main.BFS();

        boolean flag = true;

        int answer = Integer.MIN_VALUE;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 0) flag = false;
            }
        }

        if (flag) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    answer = Math.max(answer, dist[x][y]);
                }
            }
        }

        if (flag == false) answer = -1;

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
