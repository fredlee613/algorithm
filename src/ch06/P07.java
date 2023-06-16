package ch06;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 7. 좌표 정렬
 */
class Coordinate implements Comparable<Coordinate> {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate c) {
        if (this.x == c.x) return this.y - c.y;
        else return this.x - c.x;
    }



}
public class P07 {
    public static void main(String[] args) throws IOException {
        P07 main = new P07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        int n = Integer.parseInt(stdIn.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            coordinates.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        stdOut.write(main.sortCoordinates(n, coordinates));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String sortCoordinates(int n, ArrayList<Coordinate> coordinates) {
        String answer = "";
        Collections.sort(coordinates);
        for (int i = 0; i < n; i++) {
            if (i < n - 1) answer += coordinates.get(i).x + " " + coordinates.get(i).y + "\n";
            else answer += coordinates.get(i).x + " " + coordinates.get(i).y;
        }
        return answer;
    }
}
