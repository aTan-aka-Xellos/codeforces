import java.io.*;
import java.util.*;

/**
 * https://codeforces.com/contest/1038/problem/C
 */
public class Solution1038C {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();

        Integer[] a = in.readArray(n);
        Integer[] b = in.readArray(n);

        out.print(count(a, b, n));
        out.flush();
        out.close();

//        test();
    }

    private static long count(Integer[] a, Integer[] b, int n) {
        long diff = 0L;

        Arrays.sort(a);
        Arrays.sort(b);

        LinkedList<Integer> aa = new LinkedList<>(Arrays.asList(a));
        LinkedList<Integer> bb = new LinkedList<>(Arrays.asList(b));

        while(!aa.isEmpty() || !bb.isEmpty()) {
            diff += extract(aa, bb);
            diff -= extract(bb, aa);
        }

        return diff;
    }

    private static Integer extract(LinkedList<Integer> a, LinkedList<Integer> b) {
        if (a.isEmpty()) {
            b.removeLast();
        } else
        if (b.isEmpty()) {
            return a.pollLast();
        } else
        if (a.getLast() >= b.getLast()) {
            return a.pollLast();
        } else {
            b.removeLast();
        }
        return 0;
    }

    private static void test() {
        test(count(new Integer[]{10}, new Integer[]{10}, 1), 0);
        test(count(new Integer[]{2}, new Integer[]{3}, 1), 0);
        test(count(new Integer[]{4}, new Integer[]{3}, 1), 1);
        test(count(new Integer[]{3}, new Integer[]{4}, 1), 0);

        test(count(new Integer[]{2, 2, 2}, new Integer[]{3, 3, 3}, 3), -1);
        test(count(new Integer[]{3, 3, 3}, new Integer[]{2, 2, 2}, 3), 2);

        test(count(new Integer[]{1, 4}, new Integer[]{5, 1}, 2), 0);
        test(count(new Integer[]{100, 100, 100}, new Integer[]{100, 100, 100}, 3), 0);
        test(count(new Integer[]{2, 1}, new Integer[]{5, 6}, 2), -3);

    }

    private static void test(long actual, long expected) {
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

        Integer[] readArray(int n) {
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

    }
}