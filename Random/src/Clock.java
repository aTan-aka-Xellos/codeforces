/**
 * https://vk.com/@tproger-clock
 * How many times all hour hands is intersected per day.
 *
 * Note: in this solution deviation of seconds is ignored.
 */
public class Clock {

    public static void main(String[] args) {

        int count = 0;

        for (int h = 0; h < 12; ) {
            for (int m = 0; m < 60; ) {
                for (int s = 0; s <= 60; s++) {
                    if (s == 60) m++;
                    if (h * 5 == m && m == s) {
                        count++;
                        System.out.println(h + " " + m + " " + s);
                    }
                }
                if (m == 60) h++;
            }
        }
        System.out.println("Per day: " + count * 2);
    }
}
