import static java.lang.String.format;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Template for contests.
 * Methods split into util classes.
 * Support test from txt source.
 * @author aTan-aka-Xellos
 */
public class Template {

    private static ByteArrayOutputStream interceptedStream = new ByteArrayOutputStream();
    private static PrintStream systemOut = System.out;
    private static InputReader in  = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);


    public static void main(String[] args) throws IOException {

        String testFile = "<folder>/test/%s";
        String testAns  = "<folder>/test/%sa";


        for (int k = 1; k <= 10; k++) {

            enableTestFromFile(format(testFile, k));
            solve();

            long[] ans = getResultsFromInterceptedStream();
            Assert.assertEquals(ans, $.readFileAsLong(format(testAns , k)));

            out.flush();
        }

//        solve();
        out.flush();
        out.close();
    }

    static void solve() {

    }

    private static void enableTestFromFile(String fileName) throws IOException {
        System.setOut(new PrintStream(interceptedStream));
        out = new PrintWriter(System.out);
        in = new InputReader(new File(fileName));
    }


    private static long[] getResultsFromInterceptedStream() {
        out.flush();
        String[] stringArray = interceptedStream.toString().split("\r\n");

        interceptedStream.reset();
        System.setOut(systemOut);
        out = new PrintWriter(System.out);

        return $.arrayStringToLong(stringArray);
    }


    /**
     * Assert method for testing.
     */
    private static class Assert {

        static void assertEquals(int actual, int expected) {
            if (actual != expected) {
                throw new RuntimeException("\n" + actual + " != "  + expected);
            }
        }

        static void assertEquals(long actual, long expected) {
            if (actual != expected) {
                throw new RuntimeException("\n" + actual + " != "  + expected);
            }
        }

        static void assertEquals(int[] actual, int[] expected) {
            if (!Arrays.equals(actual, expected)) {
                throw new RuntimeException("\n" + Arrays.toString(actual)
                    + "\n" + Arrays.toString(expected));
            }
        }

        static void assertEquals(long[] actual, long[] expected) {
            if (!Arrays.equals(actual, expected)) {
                throw new RuntimeException("\n" + Arrays.toString(actual)
                    + "\n" + Arrays.toString(expected));
            }
        }
    }


    /**
     * Class for read input.
     */
    private static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        /**
         * Read from file.
         */
        InputReader(File file) throws FileNotFoundException {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 32768);
            tokenizer = null;
        }

        /**
         * Read from stream.
         */
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

    /**
     * Util class with different util methods.
     */
    private static class $ {

        static int[] ints(int... args) {
            return args;
        }

        static long[] longs(long... args) {
            return args;
        }

        static String[] strings(String... args) {
            return args;
        }

        static long[] arrayStringToLong(String[] stringArray) {
            long[] longArray = new long[stringArray.length];

            for (int i = 0; i < stringArray.length; i++) {
                longArray[i] = Long.parseLong(stringArray[i]);
            }
            return longArray;
        }

        static int[] arrayStringToInt(String[] stringArray) {
            int[] intArray = new int[stringArray.length];

            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            return intArray;
        }

        static long GCD(long a, long b) {
            return b == 0 ? a : GCD(b, a % b);
        }

        static boolean isPrime(long n) {
            if (n == 1) return false;

            long limit = (long) Math.sqrt(n);
            for (long i = 2; i <= limit; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

        static String[] readFile(String fileName) {
            List<String> list = new ArrayList<>();

            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                list = stream.collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list.toArray(new String[0]);
        }

        static long[] readFileAsLong(String fileName) {
            return arrayStringToLong(readFile(fileName));
        }

        static int[] readFileAsInt(String fileName) {
            return arrayStringToInt(readFile(fileName));
        }
    }
}
