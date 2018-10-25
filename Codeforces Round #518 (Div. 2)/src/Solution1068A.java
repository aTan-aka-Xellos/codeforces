import static java.lang.Math.abs;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1068/problem/A
 */
public class Solution1068A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        long n = in.nextLong();
        long m = in.nextLong();
        long k = in.nextLong();
        long l = in.nextLong();

        out.println(solve(n, m, k, l));
        out.flush();
        out.close();

//        test();
    }

    private static long solve(long total, long friends, long oldCoins, long newCoins) {

        long numberPerFriend = (oldCoins + newCoins) / friends;
        if ((oldCoins + newCoins) % friends != 0) numberPerFriend++;

        return numberPerFriend * friends > total ? -1 : numberPerFriend;
    }

    private static void test() {
        test(solve(20, 15, 2, 3), 1, 1);
        test(solve(10, 11, 2, 4), -1, 2);
        test(solve(100, 10, 10, 20), 3, 3);
        test(solve(100, 10, 100, 20), -1, 4);
        test(solve(100, 10, 99, 1), 1, 5);
    }


    private static void test(long actual, long expected, int index) {
        if (actual != expected) {
            System.out.println(index + " " + actual + " != " + expected);
        }
    }

    private static long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a%b);
    }

    private static boolean isPrime(long n) {
        if (n == 1) return false;

        long limit = (long) Math.sqrt(n);
        for (long i = 2; i <= limit; i++) {
            if (n % i == 0) return false;
        }
        return true;
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

        long[][] readDoubleArrayLong(int n) {
            long[][] array = new long[n][2];
            for (int i = 0; i < n; i++) {

                array[i][0] = nextLong();
                array[i][1] = nextLong();
            }
            return array;
        }
    }
}