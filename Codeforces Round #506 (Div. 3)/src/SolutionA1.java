import java.io.*;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/1029/problem/A
 */
public class SolutionA1 {

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

        String appendix;
        String temp = t;

        do {
            temp = temp.substring(0, temp.length() - 1);
            appendix = t.substring(temp.length(), n);
        }  while (!t.equals((t + appendix).substring(appendix.length())));

        StringBuilder sb = new StringBuilder(t);
        for (int i = 1; i < k; i++) {
            sb.append(appendix);
        }

        return sb.toString();
    }


    private static void test(String actual, String expected) {
        if (!actual.equals(expected)) System.err.println(actual + " != " + expected);
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
}