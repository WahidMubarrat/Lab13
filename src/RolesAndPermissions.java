public class RolesAndPermissions extends Main {
    //        ************************************************************ Behaviours/Methods ************************************************************

    /**
     * Checks if the admin with specified credentials is registered or not.
     * @param username of the imaginary admin
     * @param password of the imaginary admin
     * @return -1 if admin not found, else index of the admin in the array.
     */
    public int isPrivilegedUserOrNot(String username, String password) {
        int isFound = -1;
        for (int i = 0; i < adminUserNameAndPassword.length; i++) {
            if (username.equals(adminUserNameAndPassword[i][0]) &&
                    password.equals(adminUserNameAndPassword[i][1])) {
                return i;
            }
        }
        return isFound;
    }

    /**
     * Checks if the passenger with specified credentials is registered or not.
     * @param email of the specified passenger
     * @param password of the specified passenger
     * @return 1 with the userID if the passenger is registered, else 0
     */
    public String isPassengerRegistered(String email, String password) {
        String isFound = "0";
        for (Customer customer : Customer.customerCollection) {
            if (email.equals(customer.getEmail()) &&
                    password.equals(customer.getPassword())) {
                return "1-" + customer.getUserID();
            }
        }
        return isFound;
    }
}
