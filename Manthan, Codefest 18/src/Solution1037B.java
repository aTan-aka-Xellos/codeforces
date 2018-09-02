import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * https://codeforces.com/contest/1037/problem/B
 */
public class Solution1037B {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int m = in.readInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = in.readInt();
        }

        out.print(solve(array, n, m));
        out.flush();
        out.close();

//        test();
    }

    private static long solve(int[] a, int n, int m) {

        long counter = 0;
        int middle = n / 2;
        Arrays.sort(a);

        for (int i = 0; i <= middle; i++) {
            if (a[i] > m) counter += a[i] - m;
        }

        for (int i = middle; i < n; i++) {
            if (a[i] < m) counter += m - a[i];
        }

        return counter;
    }

    private static void test() {
        test(solve(new int[]{5}, 1, 5), 0);
        test(solve(new int[]{5}, 1, 7), 2);

        test(solve(new int[]{6, 5, 8}, 3, 8), 2);
        test(solve(new int[]{21, 15, 12, 11, 20, 19, 12}, 7, 20), 6);
        test(solve(new int[]{21, 15, 12, 11, 21, 19, 12}, 7, 20), 6);
        test(solve(new int[]{14, 20, 10, 15, 12, 18, 22}, 7, 11), 8);

        test(solve(new int[]{5, 6, 7, 15, 15, 15, 15}, 7, 20), 20);
        test(solve(new int[]{5, 5, 5, 5, 15, 15, 15}, 7, 0), 20);
    }

        private static void test(long actual, long expected) {
        if (actual != expected) {
            System.out.println(actual + " != " + expected);
        }
    }


    /**
     * Copied from @author Egor Kulikov
     */
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private InputReader.SpaceCharFilter filter;
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);

        }

    }
}