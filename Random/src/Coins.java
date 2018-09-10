import java.util.Arrays;

/**
 * https://habr.com/post/109384
 */
public class Coins {

    public static void main(String[] args) {

        System.out.println(getCombination(30000));
        System.out.println(getCombination(17)); // 6
        System.out.println(getCombination(11)); // 4
        System.out.println(getCombination(4));  // 1
    }

    private static long getCombination(int n) {

        int[] nominal = new int[]{1, 5, 10, 25, 50};

        long[][] d = new long[5][30001];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(d[i], 0L);
        }

        d[0][0] = 1;

        for (int i = 0; i < 30000; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j; k < 5; k++) {
                    if (i + nominal[k] <= 30000) {
                        d[k][i + nominal[k]] += d[j][i];
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += d[i][n];
        }

        return ans;

    }
}
