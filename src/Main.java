public class Main {
    public static void main(String[] args) {

        // Print a hello message
        System.out.println("Hello world!");

        // Create a new EmployeeList
        EmployeeList list = new EmployeeList();

        // Generate a list of 1500 random employees
        list.createRandomList(1500);

        // Sort the employee list by salary
        list.employeeListSort();

        // Print the sorted list of employees
        list.printEmployeeList();
    }
}
