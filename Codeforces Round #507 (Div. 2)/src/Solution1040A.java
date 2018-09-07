import java.io.*;
import java.util.InputMismatchException;

/**
 * https://codeforces.com/contest/1040/problem/A
 */
public class Solution1040A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int a = in.readInt();
        int b = in.readInt();

        int[] c = in.readIntArray(n);

        out.print(count(n, a, b, c));
        out.flush();
        out.close();

//        test();
    }

    private static int count(int n, int a, int b, int[] c) {

        int sum = 0;

        for (int i = 0; i < n / 2; i++) {
            int left = c[i];
            int right = c[n - i - 1];

            if (left != right && left != 2 && right != 2) return -1;

            if (left == 2 && right == 2) sum += 2 * Math.min(a, b);

            if (left != right) {
                if (left == 0 || right == 0) sum += a;
                if (left == 1 || right == 1) sum += b;
            }
        }

        if (n % 2 != 0 && c[n / 2] == 2) sum += Math.min(a, b);

        return sum;

    }

    private static void test() {

        test(count(2, 9, 6,  new int[]{2, 2}), 12);

        test(count(5, 100, 1, new int[]{0, 1, 2, 1, 2}), 101);
        test(count(3, 10, 12, new int[]{1, 2, 0}), -1);
        test(count(3, 12, 1,  new int[]{0, 1, 0}), 0);

        test(count(1, 10, 20,  new int[]{0}), 0);
        test(count(1, 10, 20,  new int[]{1}), 0);
        test(count(1, 10, 20,  new int[]{2}), 10);

        test(count(2, 10, 20,  new int[]{1, 0}), -1);
        test(count(2, 10, 20,  new int[]{1, 2}), 20);
        test(count(2, 10, 20,  new int[]{1, 1}), 0);


    }

        private static void test(int actual, int expected) {
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