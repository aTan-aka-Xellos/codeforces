import java.io.*;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/1029/problem/A
 */
public class Solution1029A2 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int k = sc.nextInt();

        String t = sc.next();

        String result = append(n, k, t);

        out.println(result);
        out.flush();
        out.close();

    }

    private static String append(int n, int k, String t) {

        int index = 0;

        for (int i = 1; i < n; i++) {
            if (t.substring(0, i).equals(t.substring(n - i, n))) {
                index = i;
            }
        }

        String appendix = t.substring(index);

        StringBuilder sb = new StringBuilder(t.substring(0, index));
        for (int i = 1; i <= k; i++) {
            sb.append(appendix);
        }

        return sb.toString();
    }

/*
        test(append(3, 2, "cat"), "catcat");
        test(append(1, 1, "a"),   "a");
        test(append(1, 3, "a"),   "aaa");
        test(append(2, 3, "cc"),  "cccc");
        test(append(3, 2, "qqq"), "qqqq");
        test(append(3, 1, "ddd"), "ddd");
        test(append(3, 4, "aba"),       "ababababa");
        test(append(3, 4, "aba"),       "ababababa");
        test(append(5, 3, "ababa"),     "ababababa");
        test(append(7, 3, "abababa"),   "abababababa");
        test(append(9, 3, "ababababa"), "ababababababa");
        test(append(8, 3, "abcaabca"),  "abcaabcaabcaabca");
        test(append(6, 3, "abccda"),    "abccdabccdabccda");
        test(append(6, 3, "abcabc"),    "abcabcabcabc");
        test(append(7, 3, "abcabca"),   "abcabcabcabca");
 */

    private static void test(String actual, String expected) {
        if (!actual.equals(expected)) System.err.println(actual + " != " + expected);
    }

}