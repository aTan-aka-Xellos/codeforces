import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1033/problem/B
 */
public class Solution1033B {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.nextInt();
        long[][] arr = in.readDoubleArrayLong(t);

        for (int i = 0; i < t; i++) {
            if ((arr[i][0] - arr[i][1] == 1) && (isPrime(arr[i][0] + arr[i][1]))) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }

        out.flush();
        out.close();
    }

    private static boolean isPrime(long n) {

        if ((n > 2 && n % 2 == 0) || n == 1) {
            return false;
        }

        long lim = (long) Math.sqrt(n);
        for (int i = 3; i <= lim; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    private static boolean testPrime(long a, long b) {

        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);

        bigA = bigA.multiply(bigA);
        bigB = bigB.multiply(bigB);

        BigInteger bigS = bigA.subtract(bigB);
        return bigS.isProbablePrime(9);
    }

    private static long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a%b);
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