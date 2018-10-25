import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1068/problem/B
 */
public class Solution1068B {


    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        long n = in.nextLong();

        out.println(solve(n));
        out.flush();
        out.close();

//        test();
    }

    private static int solve(long b) {

        int count = 0;

        long lim = (long) Math.sqrt(b);

        for (long i = 1; i <= lim; i++) {
            if (b % i == 0) {
                count++;
                if (i * i < b) count++;
            }
        }

        return count;
    }


    private static void test() {

        test(solve(1), 1);
        test(solve(2), 2);
        test(solve(3), 2);
        test(solve(16), 5);

    }

    private static void test(int actual, int expected) {
        if (actual != expected) {
            System.out.println(actual + " != " + expected);
        }
    }

    private static long lcm(long a, long b) {
        return Math.abs(a * (b / gcd(a, b)));
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a%b);
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

        boolean hasNext() {
            try {
                return reader.ready();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
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