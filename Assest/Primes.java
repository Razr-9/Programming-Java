/**
 * Primes
 */
public class Primes {

    public static void main(String[] args) {
        for (int i = Integer.parseInt(args[0]); i <= Integer.parseInt(args[1]); i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number > 1) {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}