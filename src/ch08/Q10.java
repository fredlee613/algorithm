package ch08;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 10. 미로탐색(DFS)
 */
public class Q10 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze = new int[8][8];
    static int answer = 0;

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    DFS(nx, ny);
                    maze[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q10 main = new Q10();
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
        main.DFS(1, 1);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
