package ch08;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 11. 미로의 최단거리 통로(DFS)
 */
public class Q11 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze = new int[8][8];
    static int[][] dist = new int[8][8];
    static int answer = 0;

    public void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        maze[x][y] = 1;
        while (!q.isEmpty()) {
            Point cp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    dist[nx][ny] = dist[cp.x][cp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q11 main = new Q11();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int x = 1; x <= 7; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 1; y <= 7; y++) {
                maze[x][y] = Integer.parseInt(st.nextToken());
            }
        }
        maze[1][1] = 1;
        main.BFS(1, 1);

        if (dist[7][7] == 0) answer = -1; // 갈 수 없을 경우 -1 출력
        else answer = dist[7][7];
        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
