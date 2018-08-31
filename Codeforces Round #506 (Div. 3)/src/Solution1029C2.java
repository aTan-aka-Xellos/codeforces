import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/1029/problem/C
 */
public class Solution1029C2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        int a0 = 0, a1 = 0, b0 = Integer.MAX_VALUE, b1 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            start[i] = Integer.parseInt(sc.next());
            end[i]   = Integer.parseInt(sc.next());

            if (start[i] > a1) {
                a0 = a1;
                a1 = start[i];
            } else {
                a0 = max(a0, start[i]);
            }

            if (end[i] < b0) {
                b1 = b0;
                b0 = end[i];
            } else {
                b1 = min(b1, end[i]);
            }
        }

        int result = 0;

        if (isSameSegment(start, end, a1, b0)) {
            result = b1 - a0;
        } else if (!(a0 > b0 && a1 > b1)) {
            result = max(b0 - a0, b1 - a1);
        }

        out.println(result);
        out.flush();
        out.close();
    }


    private static boolean isSameSegment(int[] start, int[] end, int a, int b) {
        for (int i = 0; i < start.length; i++) {
            if (start[i] == a && end[i] == b) return true;
        }
        return false;
    }

    private static void test(int actual, int expected) {
        if (actual != expected) System.out.println(actual + " != " + expected);
    }

}