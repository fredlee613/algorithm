package ch02;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 10. 봉우리
 */

public class Q10 {

    String solution(int count, int[][] arr) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int x = 0; x < count; x++) {
            for (int y = 0; y < count; y++) {
                boolean flag = true;
                for (int z = 0; z < 4; z++) {
                    int nx = x + dx[z];
                    int ny = y + dy[z];
                    if (nx >= 0 && nx < count && ny >=0 && ny < count && arr[nx][ny] >= arr[x][y]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q10 q10 = new Q10();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(stdIn.readLine());
        int[][] list = new int[count][count];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < count; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        stdOut.write(q10.solution(count, list));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
