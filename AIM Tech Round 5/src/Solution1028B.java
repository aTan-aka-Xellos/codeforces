import java.io.PrintWriter;

/**
 * https://codeforces.com/contest/1028/problem/B
 */
public class Solution1028B {

    public static void main(String[] args) {

        PrintWriter out = new PrintWriter(System.out);

        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < 400; i++) {
            a.append(3);
            b.append(6);
        }

        a.append(5);
        b.append(5);

        out.println(a);
        out.println(b);

        out.flush();
        out.close();

    }

}