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
        model = new ManageUsersModel(queryTool);
    }
    
    @Test
    public void testEmpty() {
        User[] users = {};
        assertArrayEquals(users, model.getUsers());
    }
    
    @Test
    public void testFetch() {
        model.fetch();
        assertEquals(1, queryTool.getFetchAllCallCount());
        assertArrayEquals(model.getUsers(), queryTool.fetchAll());
    }
    
    @Test
    public void testGoodDelete() {
        model.fetch();
        model.delete(1);
        assertEquals(1, queryTool.getDeleteCallCount());
        assertEquals(queryTool.fetchAll().length - 1, model.getUsers().length);
    }
    
    @Test
    public void testDeleteFirst() {
        model.fetch();
        model.delete(0);
        assertEquals(1, queryTool.getDeleteCallCount());
        assertEquals(queryTool.fetchAll().length - 1, model.getUsers().length);
    }
    
    @Test
    public void testDeleteLast() {
        model.fetch();
        model.delete(model.getUsers().length - 1);
        assertEquals(1, queryTool.getDeleteCallCount());
        assertEquals(queryTool.fetchAll().length - 1, model.getUsers().length);
    }
    
    @Test(expected=InvalidIndexException.class)
    public void testDeleteEmpty() {
        model.delete(0);
    }
    
    @Test(expected=InvalidIndexException.class)
    public void testDeleteNegative() {
        model.fetch();
        model.delete(-1);
    }
    
    @Test(expected=InvalidIndexException.class)
    public void testDeleteAfterLast() {
        model.fetch();
        model.delete(model.getUsers().length);
    }
}
