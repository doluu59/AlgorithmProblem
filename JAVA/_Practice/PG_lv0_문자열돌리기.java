package JAVA._Practice;

import java.util.Scanner;

public class PG_lv0_문자열돌리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<a.length(); i++) {
            sb.append(a.charAt(i)).append('\n');
        }

        System.out.println(sb.toString());
    }
}
