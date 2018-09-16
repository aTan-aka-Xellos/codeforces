import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1041/problem/A
 */
public class Solution1041A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        Integer n = in.nextInt();
        long a[] = in.readArrayLong(n);

        out.print(solve(n, a));
        out.flush();
        out.close();

//        test();
    }

    private static long solve(int n, long[] a) {

        Arrays.sort(a);
        return a[n - 1] - a[0] + 1 - n;
    }

    private static void test() {

        test(solve(1, new long[]{1}), 0);
        test(solve(2, new long[]{1, 2}), 0);
        test(solve(2, new long[]{1, 3}), 1);
        test(solve(2, new long[]{10, 1}), 8);
        test(solve(4, new long[]{10, 13, 12, 8}), 2);
        test(solve(5, new long[]{7, 5, 6, 4, 8}), 0);
        test(solve(2, new long[]{1, 1_000_000_000}), 999_999_998);
        test(solve(4, new long[]{1, 10, 999_999, 1_000_000_000}), 999_999_996);

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