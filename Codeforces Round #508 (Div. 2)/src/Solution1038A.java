import java.io.*;
import java.util.Scanner;

/**
 * https://codeforces.com/contest/1038/problem/A
 */
public class Solution1038A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        Scanner terminalInput = new Scanner(System.in);

        int n = terminalInput.nextInt();
        int k = terminalInput.nextInt();

        String s = terminalInput.next();

        out.print(count(n, k, s));
        out.flush();
        out.close();

//        test();
    }

    private static int count(int n, int k, String s) {

        String[] alpha = new String[k];
        for(int i = 0; i < k; i++){
            alpha[i] = String.valueOf((char)(65 + i));
        }

        StringBuilder sb = new StringBuilder(s);

        int count = 0;
        int index ;
        while(true) {
            for (String anAlpha : alpha) {
                index = sb.indexOf(anAlpha);
                if (index != -1) {
                    sb.deleteCharAt(index);
                } else {
                    return count;
                }
            }
            count += alpha.length;
        }
    }

    private static void test() {

        test(count(9, 3, "ACAABCCAB"), 6);
        test(count(9, 4, "ABCABCABC"), 0);

        test(count(5, 5, "ABCDE"), 5);

        test(count(1, 1, "A"), 1);
        test(count(1, 2, "A"), 0);
        test(count(2, 2, "AB"), 2);
        test(count(3, 2, "ABB"), 2);
        test(count(4, 2, "ABBA"), 4);

        test(count(5, 26, "ABBAZ"), 0);

        test(count(26, 26, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"), 26);
        test(count(53, 26, "ABCGHIJKLMDNOPSTUVDEFGHQRSTUVWXYZMNOPQRIJKLABCDEFWXYZ"), 52);


    }

        private static void test(int actual, int expected) {

        if (actual != expected) {
            System.out.println(actual + " != " + expected);
        }
    }

}