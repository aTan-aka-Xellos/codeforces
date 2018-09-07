import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1036/problem/A
 */
public class Solution1036A {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        long n = in.nextLong();
        long k = in.nextLong();

        out.print(count(n, k));
        out.flush();
        out.close();

//        test();
    }

    private static long count(long n, long k) {

        if (k <= n) return 1;
        if ((k % n) == 0) {
            return (k / n);
        } else {
            return (k / n) + 1;
        }
    }

    private static void test() {
        System.out.println(count(8, 100));

        System.out.println(count(2, 3));
        System.out.println(count(2, 5));
        System.out.println(count(3, 7));

        System.out.println(count(4, 3));
        System.out.println(count(4, 12));
        System.out.println(count(999999999999999999l, 999999999999999986l));
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

        long nextLong() {
           return Long.parseLong(next());
        }

        int nextInt() {
            try {
                return reader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

//            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

    }
}