package ch02;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 11. 임시반장 정하기
 */

public class Q11 {
    String solution(int count, int[][] arr) {
        int answer = 1;
        int biggest = 0;

//        for (int x = 0; x < count; x++) {
//            for (int y = 0; y < 5; y++) {
//                System.out.print(arr[x][y]+" ");
//            }
//            System.out.println();
//        }

        for (int x = 0; x < count; x++) {
            HashSet<Integer> set = new HashSet<>();
            for (int y = 0; y < 5; y++) {
                for (int z = 0; z < count; z++) {
                    if (x != z && arr[x][y] == arr[z][y]) {
//                        System.out.println("arr["+x+"]["+y+"] = " + arr[x][y] + "arr["+z+"]["+y+"] = " + arr[z][y]);
                        set.add(z);
                    }
                }
            }
            if (set.size() > biggest) {
//                System.out.println("x: " + x +". set.size() = " + set.size() + ", biggest = " + biggest);
                biggest = set.size();
                answer = x + 1;
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q11 q11 = new Q11();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(stdIn.readLine());
        int[][] list = new int[count][5];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < 5; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        stdOut.write(q11.solution(count, list));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
