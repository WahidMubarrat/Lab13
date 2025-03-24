import java.util.*;

public class CustomerDisplay {
    // Display-related constants
    private static final String TABLE_BORDER =
            "+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+";
    private static final String TABLE_HEADER =
            "| SerialNum  |   UserID   | Passenger Names                  | Age     | EmailID                     | Home Address                        | Phone Number            |";

    /**
     * Takes input for the new customer and adds them to programs memory.
     * isUniqueData() validates the entered email
     * and returns true if the entered email is already registered. If email is
     * already registered, program will ask the user
     * to enter new email address to get himself register.
     */
    public void addNewCustomer() {
        System.out.printf("\n\n\n%60s ++++++++++++++ Welcome to the Customer Registration Portal ++++++++++++++", "");
        Scanner read = new Scanner(System.in);
        System.out.print("\nEnter your name :\t");
        String name = read.nextLine();
        System.out.print("Enter your email address :\t");
        String email = read.nextLine();
        while (new Customer().isUniqueData(email)) {
            System.out.println(
                    "ERROR!!! User with the same email already exists... Use new email or login using the previous credentials....");
            System.out.print("Enter your email address :\t");
            email = read.nextLine();
        }
        System.out.print("Enter your Password :\t");
        String password = read.nextLine();
        System.out.print("Enter your Phone number :\t");
        String phone = read.nextLine();
        System.out.print("Enter your address :\t");
        String address = read.nextLine();
        System.out.print("Enter your age :\t");
        int age = read.nextInt();
        Customer.customerCollection.add(new Customer(name, email, password, phone, address, age));
    }

    /**
     * Searches for customer with the given ID and displays the customers' data if
     * found.
     *
     * @param ID of the searching/required customer
     */
    public void searchUser(String ID) {
        boolean isFound = false;
        Customer customerWithTheID = Customer.customerCollection.get(0);
        for (Customer c : Customer.customerCollection) {
            if (ID.equals(c.getUserID())) {
                System.out.printf("%-50sCustomer Found...!!!Here is the Full Record...!!!\n\n\n", " ");
                displayHeader();
                isFound = true;
                customerWithTheID = c;
                break;
            }
        }
        if (isFound) {
            System.out.println(toString(customerWithTheID, 1));
            System.out.printf("%10s%s\n", "", TABLE_BORDER);
        } else {
            System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", ID);
        }
    }

    /**
     * Shows the customers' data in formatted way.
     *
     * @param showHeader to check if we want to print ascii art for the customers'
     *                   data.
     */
    public void displayCustomersData(boolean showHeader) {
        displayHeader();
        Iterator<Customer> iterator = Customer.customerCollection.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            Customer c = iterator.next();
            System.out.println(toString(c, i));
            System.out.printf("%10s%s\n", "", TABLE_BORDER);
        }
    }

    /**
     * Shows the header for printing customers data
     */
    void displayHeader() {
        System.out.println();
        System.out.printf("%10s%s\n", "", TABLE_BORDER);
        System.out.printf("%10s%s%n", "", TABLE_HEADER);
        System.out.printf("%10s%s\n", "", TABLE_BORDER);
        System.out.println();
    }

    /**
     * Adds space between userID to increase its readability
     * <p>
     * Example:
     * </p>
     * <b>"920 191" is much more readable than "920191"</b>
     *
     * @param randomID id to add space
     * @return randomID with added space
     */
    String randomIDDisplay(String randomID) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i <= randomID.length(); i++) {
            if (i == 3) {
                newString.append(" ").append(randomID.charAt(i));
            } else if (i < randomID.length()) {
                newString.append(randomID.charAt(i));
            }
        }
        return newString.toString();
    }

    // Helper method to format customer data for display
    private String toString(Customer customer, int serialNumber) {
        return String.format("%10s| %-10d | %-10s | %-32s | %-7d | %-27s | %-35s | %-23s |",
                "", serialNumber, randomIDDisplay(customer.getUserID()),
                customer.getName(), customer.getAge(),
                customer.getEmail(), customer.getAddress(),
                customer.getPhone());
    }
}