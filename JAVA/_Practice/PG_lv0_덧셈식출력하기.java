package JAVA._Practice;

import java.util.Scanner;

public class PG_lv0_덧셈식출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a+b;
        System.out.println(a + " + " + b + " = " + sum);
    }
}