import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1064/problem/B
 */
public class Solution1064B {


    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            out.println(solve(in.nextInt()));
        }

        out.flush();
        out.close();
    }

    private static int solve(int a) {
        return (int) Math.pow(2, Integer.bitCount(a));
    }


    private static void test() {
        test(solve(0), 1);
        test(solve(2), 2);
        test(solve(1073741823), 1073741824);
    }


    private static void test(long actual, long expected) {
        if (actual != expected) {
            System.out.println(actual + " != " + expected);
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