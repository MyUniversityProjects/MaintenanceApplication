import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import root.entities.User;
import root.exceptions.InvalidIndexException;
import root.screens.manageusers.ManageUsersModel;
import stubs.UserQueriesStub;


public class ManageUsersModelTest {
    ManageUsersModel model;
    UserQueriesStub queryTool;
    
    @Before
    public void setUp() {
        queryTool = new UserQueriesStub();
        model = ManageUsersModel.fromDatabase(queryTool);
    }
    
    @Test
    public void testEmpty() {
        model = new ManageUsersModel(queryTool, new User[0]);
        assertArrayEquals(new User[0], model.getUsers());
    }
    
    @Test
    public void testGoodDelete() {
        model.delete(1);
        assertEquals(1, queryTool.getDeleteCallCount());
        assertEquals(queryTool.fetchPlannersMaintainers().length - 1, model.getUsers().length);
    }
    
    @Test
    public void testDeleteFirst(){
        model.delete(0);
        assertEquals(1, queryTool.getDeleteCallCount());
        assertEquals(queryTool.fetchPlannersMaintainers().length - 1, model.getUsers().length);
    }
    
    @Test
    public void testDeleteLast() {
        model.delete(model.getUsers().length - 1);
        assertEquals(1, queryTool.getDeleteCallCount());
        assertEquals(queryTool.fetchPlannersMaintainers().length - 1, model.getUsers().length);
    }
    
    @Test(expected=InvalidIndexException.class)
    public void testDeleteEmpty() {
        model = new ManageUsersModel(queryTool, new User[0]);
        model.delete(0);
    }
    
    @Test(expected=InvalidIndexException.class)
    public void testDeleteNegative() {
        model.delete(-1);
    }
    
    @Test(expected=InvalidIndexException.class)
    public void testDeleteAfterLast() {
        model.delete(model.getUsers().length);
    }
}
