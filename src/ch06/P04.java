package ch06;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. Least Recently Used
 */
public class P04 {
    public static void main(String[] args) throws IOException {
        P04 main = new P04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        int sizeOfRam = Integer.parseInt(st.nextToken());
        int sizeOfWork = Integer.parseInt(st.nextToken());
        int[] ram = new int[sizeOfRam];
        int[] work = new int[sizeOfWork];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < sizeOfWork; i++) work[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.leastRecentlyUsed(sizeOfRam, sizeOfWork, ram, work));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String leastRecentlyUsed(int sizeOfRam, int sizeOfWork, int[] ram, int[] work) {
        String answer = "";
        ram = new int[sizeOfRam];
        for (int i = 0; i < sizeOfWork; i++) {
            int currentWork = work[i];
            int pointer = hasWork(currentWork, ram); // -99 <= pointer <= sizeOfWork - 1
            if (pointer != -99) for (int j = pointer; j > 0; j--) ram[j] = ram[j - 1];
            else for (int j = ram.length - 1; j > 0; j--) ram[j] = ram[j - 1];
            ram[0] = currentWork;
        }

        for (int i = 0; i < sizeOfRam; i++) {
            if (i < sizeOfRam-1) answer += ram[i] + " ";
            else answer += String.valueOf(ram[i]);
        }
        return answer;
    }

    static int hasWork(int currentWork,  int[] ram) {
        int pointer = -99;
        for (int i = 0; i < ram.length; i++) if (ram[i] == currentWork) pointer = i;
        return pointer;
    }
}
