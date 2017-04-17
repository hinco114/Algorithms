package workspace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sanghyoun on 2017. 4. 9..
 */
public class B1697 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int ret = bfs(start,end);
            bw.write(Integer.toString(ret));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int bfs(int start, int end) {
        int[] time = new int[100001];
        Arrays.fill(time, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(start);
        time[start] = 0;
        while (!que.isEmpty()) {
            int curLocation = que.remove();
            if (curLocation == end) {
                return time[curLocation];
            }
            if ((curLocation - 1 >= 0) && (time[curLocation - 1] == -1)) {
                time[curLocation - 1] = time[curLocation] + 1;
                que.add(curLocation - 1);
            }
            if ((curLocation + 1 <= 100000) && (time[curLocation + 1] == -1)) {
                time[curLocation + 1] = time[curLocation] + 1;
                que.add(curLocation + 1);
            }
            if ((curLocation * 2 <= 100000) && (time[curLocation * 2] == -1)) {
                time[curLocation * 2] = time[curLocation] + 1;
                que.add(curLocation * 2);
            }
        }
        return -1;
    }
}