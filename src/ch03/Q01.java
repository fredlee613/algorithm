package ch03;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. 두 배열 합치기
 */
public class Q01 {
    ArrayList<Integer> solution(int size1, int[] list1, int size2, int[] list2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < size1 && p2 < size2) {
            if (list1[p1] <= list2[p2]) {
                answer.add(list1[p1]);
                p1++;
            } else {
                answer.add(list2[p2]);
                p2++;
            }
        }
        while (p1 < size1) {
            answer.add(list1[p1]);
            p1++;
        }
        while (p2 < size2) {
            answer.add(list2[p2]);
            p2++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q01 q01 = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int size1 = Integer.parseInt(stdIn.readLine());
        int[] list1 = new int[size1];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < size1; i++) {
            list1[i] = Integer.parseInt(st.nextToken());
        }

        int size2 = Integer.parseInt(stdIn.readLine());
        int[] list2 = new int[size2];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < size2; i++) {
            list2[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> answer = q01.solution(size1, list1, size2, list2);
        for (int i = 0; i < answer.size(); i++) {
            String tmp = "";
            if (i < answer.size() - 1) {
                tmp += answer.get(i) + " ";
            } else {
                tmp += answer.get(i);
            }
            stdOut.write(tmp);
        }
        stdIn.close();
        stdOut.close();
    }
}
