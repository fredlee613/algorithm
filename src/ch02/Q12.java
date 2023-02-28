package ch02;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 12. 멘토링
 */

public class Q12 {
    String solution(int student, int test, int[][] arr) {
        int answer = 0;
//        for (int x = 0; x < test; x++) {
//            for (int y = 0; y < student; y++) {
//                System.out.print(arr[x][y] + " ");
//            }
//            System.out.println();
//
//        }
        for (int x = 0; x < student - 1; x++) {
            HashSet<Integer> set =new HashSet<>();
            int tmp = arr[0][x];
            for (int y = x+1; y < student; y++) {
                set.add(arr[0][y]);
            }
            for (int z = 1; z < test; z++) {
                for (int i = 0; i < student; i++) {
                    if (arr[z][i] == tmp) break;
                    if (set.contains(arr[z][i])) set.remove(arr[z][i]);
                }
            }
            answer += set.size();
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q12 q12 = new Q12();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        int student = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken());
        int[][] list = new int[test][student];

        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < student; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        stdOut.write(q12.solution(student, test, list));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
