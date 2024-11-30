import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test class for EmployeeList functionality.
 * This class contains unit tests for verifying the behavior of the EmployeeList class.
 */
public class AddEmployeeToListTest {

    /**
     * Tests the addition of an employee to the EmployeeList.
     * Verifies that all attributes of the added employee are correctly stored and retrievable.
     */
    @Test
    public void testAddEmployeeToList() {
        EmployeeList list = new EmployeeList();

        // Employee details
        String id = "322218439";
        String firstName = "Shira";
        String lastName = "Asseraf";
        String Email = "shiraasseraf@gmail.com";
        String phone = "050-3371162";
        String address = "oziyaoo 10, ashdod";
        int salary = 27000;

        // Add employee to the list
        list.addEmployeeToList(id, firstName, lastName, Email, phone, address, salary);

        // Verify employee details
        assertEquals("322218439", list.getEmployee(0).getId());
        assertEquals("Shira", list.getEmployee(0).getFirstName());
        assertEquals("Asseraf", list.getEmployee(0).getLastName());
        assertEquals("shiraasseraf@gmail.com", list.getEmployee(0).getEmail());
        assertEquals("oziyaoo 10, ashdod", list.getEmployee(0).getAddress());
        assertEquals("050-3371162", list.getEmployee(0).getPhone());
        assertEquals(27000, list.getEmployee(0).getSalary());
    }
}
