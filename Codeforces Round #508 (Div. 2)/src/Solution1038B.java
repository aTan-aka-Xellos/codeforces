import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://codeforces.com/contest/1038/problem/A
 */
public class Solution1038B {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
//        InputReader in = new InputReader(System.in);

        Scanner terminalInput = new Scanner(System.in);

        int n = terminalInput.nextInt();

        if (n < 3) {
            out.print("No");
            out.flush();
            out.close();
        } else {

        int index = count(n);
        int[] a = new int[index];
        int[] b = new int[n - index];


        for (int j = 0; j < index; j++) {
            a[j] = j + 1;
        }

        for (int j = index; j < n; j++) {
            b[j - index] = j + 1;
        }

        out.println("Yes");

        StringBuilder sb = new StringBuilder(String.valueOf(a.length) + " ");

        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }

        out.println(sb.toString());

        sb = new StringBuilder(String.valueOf(b.length) + " ");

        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]).append(" ");
        }
        out.println(sb.toString());

        out.flush();
        out.close();

        }
    }

    private static int count(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp += i;
            if (GCD(sum - temp, temp) > 1) {
                return i;
            }
        }

        return -1;
    }


    private static void test() {


    }

    private static void test(int actual, int expected) {

        if (actual != expected) {
            System.out.println(actual + " != " + expected);
        }
    }

    private static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a%b);
    }

    /**
     * Copied from @author Egor Kulikov
     */
    static class InputReader {
        private InputStream stream;
        private BufferedReader reader;

        private byte[] buf = new byte[1024];
        private InputReader.SpaceCharFilter filter;
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String readString() {
            return reader.lines().collect(Collectors.joining("\n"));
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