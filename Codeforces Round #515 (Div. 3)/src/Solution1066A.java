import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1066/problem/A
 */
public class Solution1066A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = solve(in.readArrayLong(4));
        }

        for (int i = 0; i < n; i++) {
            out.println(answer[i]);
        }
        out.flush();
        out.close();

//        test();
    }

    // 0  1  2  3
    // L, v, l, r
    private static long solve(long[] a) {

        long before = a[2] / a[1];
        if (a[2] % a[1] == 0 && before > 0) before--;

        long covered = a[3] / a[1] - before;

        return a[0] / a[1] - covered;
    }

    private static void test() {
        test(solve(new long[]{10, 2, 3, 7}), 3);
        test(solve(new long[]{10, 2, 3, 8}), 2);
        test(solve(new long[]{10, 2, 2, 8}), 1);

        test(solve(new long[]{10, 1, 1, 9}), 1);
        test(solve(new long[]{10, 1, 1, 10}), 0);
        test(solve(new long[]{10, 1, 1, 1}), 9);

        test(solve(new long[]{100, 51, 51, 51}), 0);
        test(solve(new long[]{1234, 1, 100, 199}), 1134);
        test(solve(new long[]{1000000000, 1, 1, 1000000000}), 0);
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