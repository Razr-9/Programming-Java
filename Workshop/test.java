/**
 * test
 */
public class test {

    public static void main(String[] args) {
        System.out.println(testmethod(1));
        System.out.println(testmethod(2));
        System.out.println(testmethod(8));
    }

    public static String testmethod(int n) {
        String r = "none";

        switch (n) {
            case 1:
                r = "one";
            case 2:
                r = "two";
            case 3:
                r = "4";
        }
        return r;
    }
}