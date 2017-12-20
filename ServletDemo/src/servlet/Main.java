package servlet;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sa = s.substring(0,s.indexOf(" "));
        String sb = s.substring(s.indexOf(" ")+1,s.length());
        boolean flag = false;
        for (int i=0;i < sa.length();i++){
            if (!(sa.charAt(i) >= '0' && sa.charAt(i) <= '9')){
                System.out.println("error");
                flag = true;
                break;
            }
        }
        if (flag){
            return;
        }
        for (int i=0;i < sb.length();i++){
            if (!(sb.charAt(i) >= '0' && sb.charAt(i) <='9')){
                System.out.println("error");
                flag = true;
                break;
            }
        }
        if (flag){
            return;
        }
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        int i = sa.length()-1;
        int j = sb.length()-1;
        while (i >= 0 && j >= 0){
//            System.out.println("i = "+i+":j = "+j);
            int sum = (sa.charAt(i) - '0') + (sb.charAt(j) - '0') + carry;
            carry = sum/10;//进位
            sum%=10;//该位计算所得结果
            ret.append(sum);
            i--;
            j--;
//            System.out.println(ret.toString());
        }

        while (i >= 0){
            int sum = (sa.charAt(i) - '0') +carry;
            carry = sum / 10;
            sum%=10;
            ret.append(sum);
            i--;
        }
        while (j >= 0){
            int sum = (sb.charAt(j) - '0') + carry;
            carry = sum/10;
            sum%=10;
            ret.append(sum);
            j--;
        }
        if (carry != 0){
            ret.append('1');
        }
        String res = ret.toString();
        for (int k = res.length()-1;k>=0;k--){
            System.out.print(res.charAt(k));
        }
    }
}


