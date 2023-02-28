package ch04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 3. 매출액의 종류
 */
public class Q03 {
    ArrayList<Integer> solution(int num1, int num2, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        for (int i = 0; i < num2 - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int rt = num2 - 1; rt < num1; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Q03 q03 = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[num1];
        for (int i = 0; i < num1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> answer = q03.solution(num1, num2, arr);
        for (int i = 0; i < answer.size(); i++) {
            if (i < answer.size() - 1) {
                stdOut.write(answer.get(i) + " ");
            } else {
                stdOut.write(String.valueOf(answer.get(i)));
            }
        }

        stdIn.close();
        stdOut.close();
    }
}
