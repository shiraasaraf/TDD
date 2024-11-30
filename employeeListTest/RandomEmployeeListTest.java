import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 * Test class for verifying the functionality of creating a random list of employees.
 * This class contains a unit test to ensure that a random employee list is correctly created
 * and that no attributes of an employee are null or contain default values.
 */
public class RandomEmployeeListTest {

    /**
     * Tests the creation of a random employee list.
     * Verifies that the attributes of each employee are not null and that the salary is not 0.
     */
    @Test
    public void testCreateRandomEmployeeList() {

        EmployeeList list = new EmployeeList();
        list.createRandomList(10);

        // Verify that each employee has valid attributes
        for (int i = 0; i < 10; i++) {
            assertNotNull(list.getEmployee(i).getId());
            assertNotNull(list.getEmployee(i).getFirstName());
            assertNotNull(list.getEmployee(i).getLastName());
            assertNotNull(list.getEmployee(i).getEmail());
            assertNotNull(list.getEmployee(i).getPhone());
            assertNotNull(list.getEmployee(i).getAddress());
            assertNotEquals(0, list.getEmployee(i).getSalary());
        }

    }
}
