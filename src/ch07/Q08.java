package ch07;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 8. 송아지 찾기(BFS : 상태트리탐색)
 */

public class Q08 {
    static int[] directions = {1, -1, 5};
    static int[] ch;
    String solution(int person, int calf) {
        int steps = 0;
        Queue queue = new LinkedList<>();
        ch = new int[10001];
        ch[person] = 1; // 지나간 좌표에 대해서는 1로 변환 => 중복된 좌표 제거를 통한 성능 향상
        queue.offer(person);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentPosition = (int) queue.poll();
                for (int j = 0; j < 3; j++) {
                    int nextPosition = currentPosition + directions[j];
                    if (nextPosition == calf) return String.valueOf(steps);
                    if (nextPosition >= 1 && nextPosition <= 10000 && ch[nextPosition] == 0) {
                        queue.offer(nextPosition);
                        ch[nextPosition] = 1;
                    }
                }
            }
            steps++;
        }
        return String.valueOf(steps);
    }

    String countSteps(int person, int calf) {
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(person);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currentPosition = queue.poll();
                if (currentPosition == calf) return String.valueOf(steps);
                queue.offer(currentPosition + 1);
                queue.offer(currentPosition - 1);
                queue.offer(currentPosition + 5);
            }
            steps++;
        }
        return String.valueOf(steps);
    }

    public static void main(String[] args) throws IOException {
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        int person = Integer.parseInt(st.nextToken());
        int calf = Integer.parseInt(st.nextToken());

        stdOut.write(main.solution(person, calf));
        stdOut.flush();
    }
}
