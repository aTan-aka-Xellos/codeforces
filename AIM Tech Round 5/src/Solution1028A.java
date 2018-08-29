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

//        test();

    }

    private static int[] find(int n, int m, String[] arr) {

        int first_line = 0;
        int last_line = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {

            if (first_line == 0 && arr[i].contains("B")) {
                first_line = i + 1;
                last_line = first_line;
                col = (arr[i].indexOf("B") + arr[i].lastIndexOf("B")) / 2 + 1;
            }

            if (arr[i].contains("B")) {
                last_line++ ;
            }
        }

        int line = (first_line + last_line) / 2;

        return new int[]{line, col};

    }



    private static void test() {

        String[] test00 = new String[]{"B"};
        test(find(1, 1, test00), new int[]{1, 1});

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

    }

    private static void test(int[] actual, int[] expected) {
        System.out.println("Actual  : " + actual[0] + ", " + actual[1]);
        System.out.println("Expected: " + expected[0] + ", " + expected[1]);

        if (actual[0] != expected[0]) System.out.println(actual[0] + " != " + expected[0]);
        if (actual[1] != expected[1]) System.out.println(actual[1] + " != " + expected[1]);
        System.out.println();
    }
}