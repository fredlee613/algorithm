package ch02;

import java.io.*;

/**
 * 3. 가위 바위 보
 */

public class Q03 {
    String solution(int count, String a, String b) {
        String[] as = a.split(" ");
        String[] bs = b.split(" ");
        String answer = "";

        for (int i = 0; i < count; i++) {
            int tmpA = Integer.parseInt(as[i]);
            int tmpB = Integer.parseInt(bs[i]);
            if ((tmpA == 1 && tmpB == 3) || (tmpA == 2 && tmpB == 1) || (tmpA == 3 && tmpB == 2)) {
                if (i < count - 1) answer += "A" + "\n";
                else answer += "A";
            } else if (tmpA == tmpB) {
                if (i < count - 1) answer += "D" + "\n";
                else answer += "D";
            } else {
                if (i < count - 1) answer += "B" + "\n";
                else answer += "B";
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Q03 q02 = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(stdIn.readLine());
        stdOut.write(q02.solution(count, stdIn.readLine(), stdIn.readLine()));
        stdOut.flush();

        stdIn.close();
        stdOut.close();
    }
}
