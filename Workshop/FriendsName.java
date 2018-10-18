import java.util.ArrayList;
import java.util.Scanner;

/**
 * FriendsName
 */
public class FriendsName {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>(); 
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter: ");
            String temp = input.nextLine();
            if (temp.equals("print")) {
                System.out.println("+++++++++++++++");
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.print(i + " ");
                    System.out.println(arrayList.get(i));
                }
                System.out.println("+++++++++++++++");

            }else if (temp.equals("quit")) {
                break;
            } else if (temp.equals("delete")) {
                System.out.print("Enter the number to delete: ");
                int number = input.nextInt();
                input.nextLine();
                if (number < arrayList.size()) {
                    arrayList.remove(number);
                    System.out.println("Deleted successfully");
                }else{
                    System.out.println("Invalid number.");
                }
            }else if (!temp.isEmpty()&&temp.charAt(0)!=' ') {
                arrayList.add(temp);
                System.out.println("Added successfully");
            }else {
                System.out.println("Invaild input.");
            }
        }
        
    }
}