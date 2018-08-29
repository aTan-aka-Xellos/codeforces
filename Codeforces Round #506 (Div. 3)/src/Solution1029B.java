import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/1029/problem/B
 */
public class Solution1029B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        out.println(context(n, array));
        out.flush();
        out.close();
    }

    private static int context(int n, int[] array) {

        int current = 1, max = 1;

        for (int i = 1; i < n; i++) {
            if (array[i] <= array[i - 1] * 2) {
                current++;
            } else {
                current = 1;
            }
            max = Math.max(current, max);
        }
        return max;
    }

/*      Tests:

        int[] arrayT0 = {1, 2, 5, 6, 7, 10, 21, 23, 24, 49};
        test(context(10, arrayT0), 4);

        int[] arrayT1 = {2, 10, 50, 110, 250};
        test(context(5, arrayT1), 1);

        int[] arrayT2 = {4, 7, 12, 100, 150, 199};
        test(context(6, arrayT2), 3);

        int[] arrayT3 = {10};
        test(context(1, arrayT3), 1);

        int[] arrayT4 = {10, 100, 1000};
        test(context(3, arrayT4), 1);

        int[] arrayT5 = {10, 100, 1000, 1001, 2002};
        test(context(5, arrayT5), 3);
 */

    private static void test(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }

}