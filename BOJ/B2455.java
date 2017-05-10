package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by sanghyoun on 2017. 5. 8..
 */
public class B2455 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int[][] inputs = new int[4][2];
            for (int i = 0; i < 4; i++) {
                String[] str = br.readLine().split(" ");
                for (int k = 0; k < 2; k++) {
                    inputs[i][k] = Integer.parseInt(str[k]);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(solution(inputs));
            bw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int solution(int[][] nums) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < 4; i++) {
            cur -= nums[i][0];
            cur += nums[i][1];
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
