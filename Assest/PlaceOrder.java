
/**
 * PlaceOrder
 */
import java.util.Scanner;

public class PlaceOrder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Quantity: ");
        int quantity = input.nextInt();
        System.out.print("Description: ");
        input.nextLine();
        String description = input.nextLine();
        System.out.print("Unit price: ");
        double price = input.nextDouble();
        System.out.println("Order for " + quantity + " " + description.toUpperCase());
        System.out.printf("Total price %14.2f\n", price * quantity);
    }
}