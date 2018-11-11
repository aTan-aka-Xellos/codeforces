import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1055/problem/A
 */
public class Solution1055A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();
        int s = in.nextInt();

        int[] a = in.readArray(n);
        int[] b = in.readArray(n);

        out.println(solve(n, s, a, b));
        out.flush();
        out.close();

//        test();
    }


    private static String solve(int n, int s, int[] a, int[] b) {
        if (a[0] == 0) return "NO";
        if (a[s - 1] == 1) return "YES";
        if (b[s - 1] == 0) return "NO";

        for (int i = s; i < n; i++) {
            if (a[i] == 1 && b[i] == 1) return "YES";
        }
        return "NO";
    }

    private static void test() {
        test(solve(5, 3, new int[] {1, 1, 1, 1, 1}, new int[] {1, 1, 1, 1, 1}), "YES", 1);
        test(solve(5, 4, new int[] {1, 0, 0, 0, 1}, new int[] {0, 1, 1, 1, 1}), "YES", 2);
        test(solve(5, 3, new int[] {0, 1, 1, 1, 1}, new int[] {1, 1, 1, 1, 1}), "NO",  3);

        test(solve(2, 2, new int[] {1, 1},
                         new int[] {1, 1}), "YES", 4);

        test(solve(2, 2, new int[] {1, 0},
                         new int[] {1, 1}), "NO", 5);

        test(solve(3, 2, new int[] {1, 0, 1},
                         new int[] {1, 1, 1}), "YES", 6);

        test(solve(3, 2, new int[] {1, 0, 1},
                         new int[] {1, 0, 1}), "NO",  7);

        test(solve(3, 2, new int[] {1, 0, 1},
                         new int[] {1, 1, 0}), "NO", 8);

        test(solve(7, 2, new int[] {1, 0, 1, 0, 1, 0, 1},
                         new int[] {1, 1, 0, 1, 0, 1, 0}), "NO",  9);

        test(solve(7, 6, new int[] {1, 0, 1, 0, 1, 0, 1},
                         new int[] {1, 1, 0, 1, 0, 1, 0}), "NO",  10);

        test(solve(7, 7, new int[] {1, 0, 1, 0, 1, 0, 1},
                         new int[] {1, 1, 0, 1, 0, 1, 0}), "YES", 11);
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