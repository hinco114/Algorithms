package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by sanghyoun on 2017. 5. 4..
 */
public class B10797 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int day = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(" ");
            ArrayList<Integer> arr = new ArrayList<>();
            for(String num : nums) {
                arr.add(Integer.parseInt(num));
            }
            bw.write(Integer.toString(solution(day, arr)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int solution(int day, ArrayList<Integer> arr) {
        int sum = 0;
        for(int num : arr) {
            if (day == num) {
                sum++;
            }
        }
        return sum;
    }
}
