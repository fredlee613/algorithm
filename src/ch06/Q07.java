package ch06;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 7. 좌표 정렬
 */

class Point implements Comparable<Point>{
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y-o.y;
        else return this.x - o.x;
    }
}

public class Q07 {
    String solution(int n, ArrayList<Point> arr) {
        String answer = "";
        Collections.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i < n - 1) answer += arr.get(i).x + " " + arr.get(i).y + "\n";
            else answer += arr.get(i).x + " " + arr.get(i).y;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q07 q07 = new Q07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<Point> arr = new ArrayList<>();
        int n = Integer.parseInt(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        stdOut.write(q07.solution(n, arr));
        stdIn.close();
        stdOut.close();
    }
}
