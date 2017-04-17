package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by sanghyoun on 2017. 4. 16..
 */

public class B14499 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = br.readLine().split(" ");
            int ySize = Integer.parseInt(input[0]);
            int xSize = Integer.parseInt(input[1]);
            int[] defaultPos = new int[]{Integer.parseInt(input[3]), Integer.parseInt(input[2])};
            int commandSize = Integer.parseInt(input[4]);
            int[][] map = new int[ySize][xSize];
            for (int i = 0; i < ySize; i++) {
                String[] mapInput = br.readLine().split(" ");
                for (int k = 0; k < xSize; k++) {
                    map[i][k] = Integer.parseInt(mapInput[k]);
                }
            }
            String[] commands = br.readLine().split(" ");
            /*************** 입력끝 ***************/
            Dice dice = new Dice();
            DiceMap diceMap = new DiceMap(xSize, ySize, defaultPos[0], defaultPos[1], map);
            for (int i = 0; i < commandSize; i++) {
                int comm = Integer.parseInt(commands[i]);
                if (diceMap.isValid(comm)) {
                    diceMap.move(comm);
                    dice.move(comm);
                    int curNum = diceMap.getCurNum();
                    if (curNum == 0) {
                        diceMap.setCurNum(dice.getBottom());
                    } else {
                        dice.setBottom(curNum);
                        diceMap.setCurNum(0);
                    }
                    bw.write(Integer.toString(dice.getUpper()));
                    bw.newLine();
                } else {
                    continue;
                }
            }
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Dice {
    private int upper;
    private int bottom;
    private int left;
    private int right;
    private int up;
    private int down;

    public Dice() {
        upper = 0;
        bottom = 0;
        up = 0;
        left = 0;
        right = 0;
        down = 0;
    }

    public void move(int direction) {
        // 우 1 좌 2 위 3 아래 4
        int temp;
        switch (direction) {
            case 1:
                // up과 down은 변화없음
                temp = bottom;
                bottom = right;
                right = upper;
                upper = left;
                left = temp;
                break;
            case 2:
                // up과 down 은 변화없음
                temp = bottom;
                bottom = left;
                left = upper;
                upper = right;
                right = temp;
                break;
            case 3:
                // left와 right 변화없음
                temp = bottom;
                bottom = up;
                up = upper;
                upper = down;
                down = temp;
                break;
            case 4:
                // left와 right 변화없음
                temp = bottom;
                bottom = down;
                down = upper;
                upper = up;
                up = temp;
                break;
        }
    }

    public int getUpper() {
        return upper;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int num) {
        this.bottom = num;
    }
}

class DiceMap {
    private int maxXpos;
    private int maxYpos;
    private int xPos;
    private int yPos;
    private int[][] map;

    public DiceMap(int x, int y, int curX, int curY, int[][] map) {
        this.maxXpos = x - 1;
        this.maxYpos = y - 1;
        this.xPos = curX;
        this.yPos = curY;
        this.map = map;
    }

    public boolean isValid(int direction) {
        // 우 1 좌 2 위 3 아래 4
        switch (direction) {
            case 1:
                return xPos + 1 <= maxXpos;
            case 2:
                return xPos - 1 >= 0;
            case 3:
                return yPos - 1 >= 0;
            case 4:
                return yPos + 1 <= maxYpos;
        }
        return false;
    }

    public void move(int direction) {
        switch (direction) {
            case 1:
                xPos++;
                break;
            case 2:
                xPos--;
                break;
            case 3:
                yPos--;
                break;
            case 4:
                yPos++;
                break;
        }
    }

    public int getCurNum() {
        return map[yPos][xPos];
    }

    public void setCurNum(int num) {
        map[yPos][xPos] = num;
    }
}