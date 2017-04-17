package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by sanghyoun on 2017. 4. 12..
 */
public class B10799 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String input = br.readLine();
            int bars = 0;
            int sum = 0;
            for (int i = 0; i < input.length(); i++) {
                char curChar = input.charAt(i);
                if (curChar == '(') {
                    // 쇠막대기 시작
                    bars++;
                } else if (curChar == ')') {
                    bars--;
                    if (input.charAt(i - 1) == '(') {
                        // 레이저 발견
                        sum += bars;
                    } else {
                        // 쇠막대기 끝
                        sum++;
                    }
                }
            }
            bw.write(Integer.toString(sum));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
