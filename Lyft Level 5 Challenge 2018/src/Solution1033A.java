import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1033/problem/A
 */
public class Solution1033A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();

        int ax = in.nextInt();
        int ay = in.nextInt();

        int bx = in.nextInt();
        int by = in.nextInt();

        int cx = in.nextInt();
        int cy = in.nextInt();

        String result;
        if (solve(n, ax, ay, bx, by, cx, cy)) {
            result = "YES";
        } else {
            result = "NO";
        }

        out.print(result);
        out.flush();
        out.close();

//        test();
    }

    private static boolean solve(int n, int ax, int ay, int bx, int by, int cx, int cy) {

        if ((bx > ax && cx > ax) || (bx < ax && cx < ax)) {
            return by > ay && cy > ay || by < ay && cy < ay;
        }
        return false;
    }

    private static void test() {
        test(solve(8, 4, 4, 1, 3, 3, 1), true);
        test(solve(8, 4, 4, 2, 3, 1, 6), false);
        test(solve(8, 3, 5, 1, 2, 6, 1), false);
    }


    private static void test(boolean actual, boolean expected) {
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