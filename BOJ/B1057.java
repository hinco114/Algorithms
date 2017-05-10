package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Created by sanghyoun on 2017. 4. 21..
 */
public class B1057 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(Integer.toString(solution(n, a, b)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int solution(int n, int a, int b) {
        int ret = 1;

        // 주어진 수는 자연수이지만, 나누기 2의 계산의 편의를 위해 1씩 빼고 계산
        int big = a > b ? a - 1 : b - 1;
        int small = a > b ? b - 1 : a - 1;

        while (n > 1) {
            if (big / 2 == small / 2) {
                return ret;
            } else {
                if (n % 2 > 0) {
                    n = (n / 2) + 1;
                } else {
                    n /= 2;
                }
                big /= 2;
                small /= 2;
                ret++;
            }
        }
        return -1;
    }
}
