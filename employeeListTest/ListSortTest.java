import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for sorting functionality in EmployeeList.
 * This class contains unit tests for verifying that the EmployeeList is correctly sorted
 * by salary in descending order and that no employee is lost during the sorting.
 */
public class ListSortTest {

    /**
     * Tests the sorting of employees by salary in descending order.
     * Verifies that after sorting, each employee has a salary greater than or equal to the next employee.
     * Also checks that all employees are still present after sorting.
     */
    @Test
    public void testListSort() {
        EmployeeList list = new EmployeeList();
        list.createRandomList(100);

        // Store the initial employee IDs to ensure no employees are lost after sorting
        ArrayList<String> IDs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            IDs.add(list.getEmployee(i).getId());
        }

        // Sort the list by salary in descending order
        list.employeeListSort();

        // Verify that the list is sorted by salary in descending order
        for (int i = 0; i < 99; i++) {
            assertTrue(list.getEmployee(i).getSalary() >= list.getEmployee(i + 1).getSalary());
        }

        // Verify that no employees are lost after sorting
        for (int i = 0; i < 100; i++) {
            boolean found = false;
            for (int j = 0; j < IDs.size(); j++) {
                if (IDs.get(i).equals(list.getEmployee(j).getId()) && IDs.get(j) != null) {
                    found = true;
                }
            }
            assertTrue(found);
        }
    }
}
