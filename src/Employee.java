/**
 * Represents an Employee with personal, contact, and salary information.
 */
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String Email;
    private String phone;
    private String address;
    private int salary;

    /**
     * Default constructor that initializes all fields to their default values.
     */
    public Employee() {
        id = null;
        firstName = null;
        lastName = null;
        Email = null;
        phone = null;
        address = null;
        salary = 0;
    }

    /**
     * @return the employee's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the employee's ID.
     * @param id the employee's ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the employee's first name.
     * @param firstName the employee's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the employee's last name.
     * @param lastName the employee's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the employee's email address.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Sets the employee's email address.
     * @param email the employee's email address.
     */
    public void setEmail(String email) {
        Email = email;
    }

    /**
     * @return the employee's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the employee's phone number.
     * @param phone the employee's phone number.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the employee's city of residence.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the employee's city of residence.
     * @param address the employee's city of residence.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the employee's salary.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Sets the employee's salary.
     * @param salary the employee's salary.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Returns a string representation of the employee.
     * @return a string with the employee's information.
     */
    public String toString() {
        return "[id " + id + ", name " + firstName +
                " " + lastName + ", Email " + Email + ", phone "
                + phone + ", address " + address + ", salary " + salary + "₪" + "]";
    }
}
