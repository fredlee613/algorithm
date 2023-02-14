package ch01;

import java.io.*;
import java.util.ArrayList;

/**
 * 4. 단어 뒤집기
 */
public class Q04 {
    ArrayList<String> solution(ArrayList<String> list) {
        ArrayList<String> answer = new ArrayList<>();
        for (String s : list) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length/2; i++) {
                char tmp = arr[i];
                arr[i] = arr[arr.length-i-1];
                arr[arr.length-i-1] = tmp;
            }
            answer.add(String.valueOf(arr));
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q04 q04 = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> list = new ArrayList<>();
        int count = Integer.parseInt(stdIn.readLine());
        for (int i = 0; i < count; i++) {
            list.add(stdIn.readLine());
        }
        list = q04.solution(list);
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) stdOut.write(list.get(i)+"\n");
            else stdOut.write(list.get(i));
        }
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
