import java.io.*;
import java.util.StringTokenizer;

/**
 * https://codeforces.com/contest/1037/problem/C
 */
public class Solution1037C {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();
        String a = in.next();
        String b = in.next();

        out.print(invert(a, b, n));
        out.flush();
        out.close();
    }

    private static int invert(String a, String b, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (i < n - 1 && a.charAt(i) != a.charAt(i + 1) && a.charAt(i + 1) != b.charAt(i + 1)) {
                    i++;
                }
                count++;
            }
        }
        return count;
    }


    private static void test() {

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