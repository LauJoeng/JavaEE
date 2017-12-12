package servlet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int[] a1 = new int[s1[0].length()];
        int[] a2 = new int[s1[1].length()];
        for (int i = 1; i <= s1[0].length(); i++) {
            if (s1[0].charAt(i - 1) >= '0' && s1[0].charAt(i - 1) <= '9') {
                a1[i] = (int) s1[0].charAt(i - 1);
            } else {
                System.out.println("error");
                return;
            }
        }
        for (int i = 1; i <= s1[1].length(); i++) {
            if (s1[1].charAt(i - 1) >= '0' && s1[1].charAt(i - 1) <= '9') {
                a2[i] = (int) s1[1].charAt(i - 1);
            } else {
                System.out.println("error");
                return;
            }
        }
        int[] a3 = new int[a1.length > a2.length ? a1.length : a2.length];
        for (int i = a3.length; i > 0; i--) {
            if (i > a1.length) {
                a3[i] += a2[i];
                if (a3[i] >= 10) {
                    a3[i - 1] += 1;
                    a3[i] %= 10;
                }
            } else if (i > a2.length) {
                a3[i] += a1[i];
                if (a3[i] >= 10) {
                    a3[i - 1] += 1;
                    a3[i] %= 10;
                } else {
                    a3[i] += a1[i];
                    a3[i] += a2[i];
                    if (a3[i] >= 10) {
                        a3[i - 1] += 1;
                        a3[i] %= 10;
                    }
                }
            }
        }
        if (a3[0] != 0){
            System.out.print(a3[0]);
        }
        for (int i=1;i < a3.length;i++){
            System.out.print(a3[i]);
        }
    }
}
