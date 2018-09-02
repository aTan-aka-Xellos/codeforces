import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1037/problem/A
 */
public class Solution1037A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();
        out.print(count(n));
        out.flush();
        out.close();

//        test();
    }

    private static int count(int n) {

        int count = 0;
        while (n > 0) {
            n /= 2;
            count++;
        }
        return count;
    }

    private static void test() {
        test(count(1), 1);
        test(count(2), 2);
        test(count(3), 2);
        test(count(7), 3);
        test(count(8), 4);
        test(count(17), 5);
        test(count(16), 5);
        test(count(1023), 10);
        test(count(1024), 11);
    }

        private static void test(int actual, int expected) {
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

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}