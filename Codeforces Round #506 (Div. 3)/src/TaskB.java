import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/1029/problem/B
 */
public class TaskB {

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

        int max = 1;
        int[] neighbors = new int[n];
        neighbors[0] = 1;

        for (int i = 1; i < n; i++) {

            if (array[i - 1] * 2 >= array[i]) {
                neighbors[i] = neighbors[i - 1] + 1;
                if (neighbors[i] > max) {
                    max = neighbors[i];
                }
            } else {
                neighbors[i] = 1;
            }
        }
        return max;
    }

/*

        int k = 10;
        int[] arrayT = {1, 2, 5, 6, 7, 10, 21, 23, 24, 49};
        System.out.println(context(k, arrayT));

        k = 5;
        int[] arrayT1 = {2, 10, 50, 110, 250};
        System.out.println(context(k, arrayT1));

        k = 6;
        int[] arrayT2 = {4, 7, 12, 100, 150, 199};
        System.out.println(context(k, arrayT2));


        k = 1;
        int[] arrayT3 = {10};
        System.out.println(context(k, arrayT3));
        test(context(k, arrayT3), 1);

        k = 3;
        int[] arrayT4 = {10, 100, 1000};
        System.out.println(context(k, arrayT4));
        test(context(k, arrayT4), 1);

        k = 5;
        int[] arrayT5 = {10, 100, 1000, 1001, 2002};
        System.out.println(context(k, arrayT5));
        test(context(k, arrayT5), 3);
 */
    private static void test(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }

}