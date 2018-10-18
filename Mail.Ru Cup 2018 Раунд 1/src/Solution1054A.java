import static java.lang.Math.abs;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1054/problem/A
 */
public class Solution1054A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int t3 = in.nextInt();

        out.println(solve(x, y, z, t1, t2, t3));
        out.flush();
        out.close();

//        test();
    }

    // x - init floor, y - target, z - init elevator
    // t1 - stairs, t2 - elevator, t3 - doors
    private static String solve(int x, int y, int z, int t1, int t2, int t3) {
        int stairs = abs(x - y) * t1;
        int elevator = abs(x - y) * t2 + abs(z - x) * t2 + 3 * t3;

        return stairs < elevator ? "NO" : "YES";
    }

    private static void test() {
        test(solve(5, 1, 4, 4, 2, 1), "YES", 1);
        test(solve(1, 6, 6, 2, 1, 1), "NO",  2);
        test(solve(4, 1, 7, 4, 1, 2), "YES", 3);

        test(solve(1, 2, 2, 3, 2, 1), "NO", 4);
    }


    private static void test(String actual, String expected, int index) {
        if (!actual.equals(expected)) {
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