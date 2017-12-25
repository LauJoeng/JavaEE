import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, step[];
        n = sc.nextInt();
        step = new int[n];
        for (int i = 0; i < n; i++) {
            step[i] = sc.nextInt();
        }

        int len = minStep(step);
        System.out.println(len);
    }

    private static int minStep(int[] step) {
        int sum = 0;//总步数
        for (int i = 0; i < step.length;) {
            //如果到了最后一个柱子，判断能否到岸
            if(i==step.length-1&&step[i]!=0){
                sum++;
                break;
            }
            int maxLen = 0, p = 0;// maxLen代表能跳最远的柱子，p指向最远柱子的下标
            for (int j = i + 1; j <= i + step[i]; j++) {
                int l = j - i + step[j];//计算最远能跳的距离
                if (l >= maxLen) {
                    maxLen = l;
                    p = j;// p指向当前最远柱子坐标
                }
            }
            //若最远的柱子值为0,不能上岸
            if (step[i] == 0 || p == 0) {
                return -1;
            }

            i = p;//否则跳到p指向的最远坐标
            ++sum;// 步数++
            //判断是否一步就能上岸
            if(p+step[p] > step.length-1){
                ++sum;
                break;
            }
        }
        return sum;
    }

}