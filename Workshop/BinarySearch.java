/**
 * BinarySearch
 */
public class BinarySearch {

    public static void main(String[] args) {
        double a = 33554431;
        int i = 0;
        do {
            a = a / 2;
            i++;
        } while (a > 2);
        System.out.println(i+1);
    }
}