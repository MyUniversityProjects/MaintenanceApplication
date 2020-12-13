package entitiestest;

import org.junit.Test;
import static org.junit.Assert.*;
import root.entities.User;
import root.entities.User.UserRole;


public class UserTest {
    
    @Test
    public void testRoleConvertPlanner() {
        assertEquals(UserRole.PLANNER, User.convertRawRole("P"));
    }
    
    @Test
    public void testRoleConvertSystemAdministrator() {
        assertEquals(UserRole.SYSTEM_ADMINISTRATOR, User.convertRawRole("SA"));
    }

    @Test
    public void testRoleConvertMaintainer() {
        assertEquals(UserRole.MAINTAINER, User.convertRawRole("M"));
    }
    
    @Test
    public void testRoleConvertNull() {
        assertNull(User.convertRawRole(null));
    }
    
    @Test
    public void testRoleConvertEmpty() {
        assertNull(User.convertRawRole(""));
    }
    
    @Test
    public void testRoleConvertLowerCasePlanner() {
        assertNull(User.convertRawRole("p"));
    }
    
    @Test
    public void testRoleConvertLowerCaseSystemAdministrator() {
        assertNull(User.convertRawRole("sa"));
    }
    
    @Test
    public void testRoleConvertLowerCaseMaintainer() {
        assertNull(User.convertRawRole("m"));
    }
    
    @Test
    public void testRoleConvertPlannerBoundaries() {
        assertNull(User.convertRawRole("(P"));
        assertNull(User.convertRawRole("P/"));
    }
    
    @Test
    public void testRoleConvertSystemAdministratorBoundaries() {
        assertNull(User.convertRawRole("2SA"));
        assertNull(User.convertRawRole("SA^"));
        assertNull(User.convertRawRole("S'A"));
        assertNull(User.convertRawRole("A"));
        assertNull(User.convertRawRole("S"));
    }
    
    @Test
    public void testRoleConvertMaintainerBoundaries() {
        assertNull(User.convertRawRole(",M"));
        assertNull(User.convertRawRole("M#"));
    }
}
