package ch06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 10. 마구간 정하기(결정알고리즘)
 */
public class P10 {
    public static void main(String[] args) throws IOException {
        P10 main = new P10();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        int countOfBarns = Integer.parseInt(st.nextToken());
        int countOfHorses = Integer.parseInt(st.nextToken());
        int[] barns = new int[countOfBarns];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < countOfBarns; i++) barns[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.locatingHorses(countOfBarns, countOfHorses, barns));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

    String locatingHorses(int countOfBarns, int countOfHorses, int[] barns) {
        Arrays.sort(barns);
        int answer = 0;
        int rt = barns[countOfBarns - 1] - barns[0], lt = 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(mid, barns) >= countOfHorses) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return String.valueOf(answer);
    }

    int count(int distance, int[] barns) {
        int former = barns[0], cnt = 1;
        for (int barn : barns) {
            if (barn == barns[0]) continue;
            if (barn - former >= distance) {
                cnt++;
                former = barn;
            }
        }
        return cnt;
    }
}
