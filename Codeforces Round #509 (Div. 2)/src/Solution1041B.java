import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1041/problem/B
 */
public class Solution1041B {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        long a = in.nextLong();
        long b = in.nextLong();
        long x = in.nextLong();
        long y = in.nextLong();

        out.print(solve(a, b, x, y));
        out.flush();
        out.close();

//        test();
    }

    private static long solve(long a, long b, long x, long y) {

        long gcd = GCD(x, y);

        x /= gcd;
        y /= gcd;

        return Math.min(a / x, b / y);
    }

    private static void test() {

        test(solve(1, 1, 1, 1), 1);
        test(solve(1, 2, 1, 1), 1);
        test(solve(2, 2, 1, 1), 2);
        test(solve(1, 1, 2, 1), 0);


        test(solve(17, 15, 5, 3), 3);
        test(solve(14, 16, 7, 22), 0);
        test(solve(14, 2, 6, 4), 1);
        test(solve(1000000000000000000L, 1000000000000000000L,
            999999866000004473L, 999999822000007597L), 1000000063);

    }

    private static long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a%b);
    }

    private static void test(long actual, long expected) {
        if (actual != expected) {
            System.out.println(actual + " != " + expected);
        }
    }


    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {

            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        long nextLong() {
           return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        long[] readArrayLong(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {

                array[i] = nextLong();
            }
            return array;
        }
    }
}