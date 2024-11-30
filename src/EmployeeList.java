import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a list of employees and provides methods to manage them.
 */
public class EmployeeList {

    /**
     * A list that holds all employees.
     */
    ArrayList<Employee> employeesList;

    /**
     * Constructs an EmployeeList and initializes the employee list.
     */
    public EmployeeList() {
        employeesList = new ArrayList<>();
    }

    /**
     * Adds a new employee to the list with the specified details.
     *
     * @param id        the employee's ID.
     * @param firstName the employee's first name.
     * @param lastName  the employee's last name.
     * @param Email     the employee's email address.
     * @param phone     the employee's phone number.
     * @param address   the employee's address.
     * @param salary    the employee's salary.
     */
    public void addEmployeeToList(String id, String firstName, String lastName, String Email,
                                  String phone, String address, int salary) {

        Employee newEmployee = new Employee();

        newEmployee.setId(id);
        newEmployee.setFirstName(firstName);
        newEmployee.setLastName(lastName);
        newEmployee.setEmail(Email);
        newEmployee.setPhone(phone);
        newEmployee.setAddress(address);
        newEmployee.setSalary(salary);

        employeesList.add(newEmployee);
    }

    /**
     * Loads a random line from a file.
     *
     * @param fileName the name of the file to load data from.
     * @return a random line from the file, or null if the file is empty.
     */
    String loadRandomLineFromFile(String fileName) {

        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(data.size());
        return data.get(index);
    }

    /**
     * Creates a list of random employees.
     *
     * @param amount the number of employees to create.
     */
    public void createRandomList(int amount) {

        Random random = new Random();

        for (int i = 0; i < amount; i++) {

            Employee newEmployee = new Employee();
            newEmployee.setId(loadRandomLineFromFile("employeeData/randomIds.txt") + random.nextInt(10, 100));
            newEmployee.setFirstName(loadRandomLineFromFile("employeeData/firstNames.txt"));
            newEmployee.setLastName(loadRandomLineFromFile("employeeData/lastNames.txt"));
            newEmployee.setEmail(newEmployee.getFirstName() + newEmployee.getLastName() + random.nextInt(0, 500) +
                    loadRandomLineFromFile("employeeData/emailDomains.txt"));
            newEmployee.setPhone(loadRandomLineFromFile("employeeData/randomMobileNumbers.txt"));
            newEmployee.setAddress(loadRandomLineFromFile("employeeData/randomStreets.txt") + " "
                    + loadRandomLineFromFile("employeeData/cities.txt"));
            newEmployee.setSalary(random.nextInt(3000, 15000));

            employeesList.add(newEmployee);
        }
    }

    /**
     * Retrieves the employee at the specified index in the list.
     *
     * @param index the index of the employee to retrieve.
     * @return the employee at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     */
    public Employee getEmployee(int index) {
        if (index >= 0 && index < employeesList.size()) {
            return employeesList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * Sets the employee at the specified index in the list.
     *
     * @param index    the index at which to set the employee.
     * @param employee the employee to set.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     */
    public void setEmployee(int index, Employee employee) {
        if (index >= 0 && index < employeesList.size()) {
            employeesList.set(index, employee);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * Prints the list of employees.
     */
    public void printEmployeeList() {

        for (int i = 0; i < employeesList.size(); i++) {
            System.out.println("employee " + (i + 1) + " " + employeesList.get(i).toString());
        }
    }

    /**
     * Bubble sort for sorting employees by salary in descending order.
     */
    public void bubbleSort() {

        for (int i = 0; i < employeesList.size() - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < employeesList.size() - 1 - i; j++) {
                if (getEmployee(j).getSalary() < getEmployee(j + 1).getSalary()) {
                    Employee temp = getEmployee(j);
                    setEmployee(j, getEmployee(j + 1));
                    setEmployee(j + 1, temp);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

    }

    /**
     * Merge sort algorithm to sort employees by salary in descending order.
     */
    public void mergeSort(List<Employee> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Split the list into two halves
            mergeSort(list, left, mid);  // Sort the left half
            mergeSort(list, mid + 1, right);  // Sort the right half

            // Merge the two halves
            merge(list, left, mid, right);
        }
    }

    /**
     * Merges two sorted halves of the list.
     *
     * @param list  the list to merge.
     * @param left  the left index of the sublist.
     * @param mid   the middle index of the sublist.
     * @param right the right index of the sublist.
     */
    public void merge(List<Employee> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Employee> leftList = new ArrayList<>(n1);
        List<Employee> rightList = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            leftList.add(list.get(left + i));
        }

        for (int j = 0; j < n2; j++) {
            rightList.add(list.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getSalary() >= rightList.get(j).getSalary()) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }

        while (i < n1) {
            list.set(k++, leftList.get(i++));
        }
        while (j < n2) {
            list.set(k++, rightList.get(j++));
        }
    }

    /**
     * Sorts the employee list by salary in descending order and measures the time taken.
     */
    public void employeeListSort() {

        long startTime = System.nanoTime();

        // bubbleSort(); // Optionally, you can use bubbleSort here instead of mergeSort.

        mergeSort(employeesList, 0, employeesList.size() - 1);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Employee list sorted in " + duration + " nanoseconds.");
    }
}
