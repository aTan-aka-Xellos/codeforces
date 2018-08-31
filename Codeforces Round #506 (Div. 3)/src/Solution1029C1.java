import static java.lang.Math.max;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/1029/problem/C
 */
public class Solution1029C1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = Integer.parseInt(sc.next());
            end[i]   = Integer.parseInt(sc.next());
        }

        out.println(count(start, end, n));
        out.flush();
        out.close();

//        test(count(new int[] {3, 2, 2}, new int[] {4, 10, 10}, 3), 8);
//        test(count(new int[] {1, 2 ,0, 3}, new int[] {3, 6, 4, 3}, 4), 1);
//        test(count(new int[] {2, 1 ,0, 1, 0}, new int[] {6, 3 ,4, 20, 4}, 5), 2);
//        test(count(new int[] {4, 1, 9}, new int[] {5, 2, 20}, 3), 0);
//        test(count(new int[] {3, 1}, new int[] {10, 5}, 2), 7);
    }

    private static int count(int[] start, int[] end, int n) {

        int[] start_sort = Arrays.copyOf(start, start.length);
        int[] end_sort = Arrays.copyOf(end, end.length);
        Arrays.sort(start_sort);
        Arrays.sort(end_sort);

        int a0 = start_sort[n - 2];
        int a1 = start_sort[n - 1];

        int b0 = end_sort[0];
        int b1 = end_sort[1];

        if (a0 > b0 && a1 > b1) return 0;

        if (isSameSegment(start, end, a1, b0)) return b1 - a0;

        return max(b0 - a0, b1 - a1);
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