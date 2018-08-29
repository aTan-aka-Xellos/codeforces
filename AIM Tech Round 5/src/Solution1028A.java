import java.io.*;
import java.util.Scanner;

/**
 * https://codeforces.com/contest/1028/problem/A
 */
public class Solution1028A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        int[] result = find(n, m, arr);

        out.println(result[0] + " " + result[1]);
        out.flush();
        out.close();

    }

    private static int[] find(int n, int m, String[] arr) {

        int first_line = -1;
        int col = 0;
        for (int i = 0; i < n; i++) {

            first_line = i + 1;
            if (arr[i].contains("B")) {
                first_line = i + 1;
                col = arr[i].indexOf("B") + 1 + (arr[i].lastIndexOf("B") - arr[i].indexOf("B"))/2;
                break;
            }
        }

        int last_line  = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i].contains("B")) {
                last_line = i + 1;
                break;
            }
        }

        int line = first_line + (last_line - first_line)/2;

        return new int[]{line, col};
    }


    private static void test(int[] actual, int[] expected) {
        System.out.println("Actual: " + actual[0] + ", " + actual[1]);
        if (actual[0] != expected[0]) System.err.println(actual[0] + " != " + expected[0]);
        if (actual[1] != expected[1]) System.err.println(actual[1] + " != " + expected[1]);
    }
    /*

        String[] test0 = new String[]{"BBBBB", "BBBBB", "BBBBB", "BBBBB", "BBBBB"};
        test(find(5, 5, test0), new int[]{3, 3});

        String[] test01 = new String[]{"WWWWW", "BBBBB", "BBBBB", "BBBBB", "BBBBB", "BBBBB"};
        test(find(6, 5, test01), new int[]{4, 3});


        String[] test1 = new String[]{"WWBBBW", "WWBBBW", "WWBBBW", "WWWWWW", "WWWWWW"};
        test(find(5, 6, test1), new int[]{2, 4});

        String[] test2 = new String[]{"WWW", "BWW", "WWW"};
        test(find(3, 3, test2), new int[]{2, 1});

        String[] test3 = new String[]{"BWW", "WWW", "WWW"};
        test(find(3, 3, test3), new int[]{1, 1});

        String[] test6 = new String[]{"WWB", "WWW", "WWW"};
        test(find(3, 3, test6), new int[]{1, 3});

        String[] test7 = new String[]{"WWW", "WWW", "BWW"};
        test(find(3, 3, test7), new int[]{3, 1});



        String[] test4 = new String[]{"WWW", "WWW", "WWB"};
        test(find(3, 3, test4), new int[]{3, 3});

        String[] test5 = new String[]{"WWWWWWWW",
            "WWBBBBBW", "WWBBBBBW", "WWBBBBBW", "WWBBBBBW", "WWBBBBBW",
            "WWWWWWWW", "WWWWWWWW", "WWWWWWWW"};
        test(find(9, 8, test5), new int[]{4, 5});
    */
}