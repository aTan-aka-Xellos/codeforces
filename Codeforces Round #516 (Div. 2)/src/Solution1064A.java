import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1064/problem/A
 */
public class Solution1064A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        out.println(solve(a, b, c));
        out.flush();
        out.close();

//        test();
    }

    private static int solve(int a, int b, int c) {
        int answer = 0;
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);

        int diff = arr[2] - (arr[0] + arr[1]);
        if (diff >= 0) answer = diff + 1;

        return answer;
    }

    private static void test() {
        test(solve(3, 4, 5), 0);
        test(solve(2, 5, 3), 1);
        test(solve(1, 1, 1), 0);

        test(solve(100, 10, 10), 81);
        test(solve(100, 100, 100), 0);
        test(solve(100, 100, 1), 0);
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