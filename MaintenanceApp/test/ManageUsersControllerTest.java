import ui.ButtonColumnActionListener;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import root.Navigable;
import root.screens.manageusers.*;
import stubs.NavigatorStub;
import stubs.UserQueriesStub;


public class ManageUsersControllerTest {
    private class ViewStub extends ManageUsersView {
        JButton back = new JButton();
        JButton create = new JButton();
        ButtonColumnActionListener deleteActionListener;
        ButtonColumnActionListener editActionListener;        
        // counters of register calls
        int backListenerCount = 0;
        int createListenerCount = 0;
        int deleteListenerCount = 0;
        int editListenerCount = 0;
        
        public ViewStub(Navigable nav, ManageUsersModel model) {
            super(nav, model);
        }

        @Override
        public void setEditUserActionListener(ButtonColumnActionListener al) {
            editActionListener = al;
            editListenerCount++;
        }

        @Override
        public void setDeleteUserActionListener(ButtonColumnActionListener al) {
            deleteActionListener = al;
            deleteListenerCount++;
        }

        @Override
        public void addCreateActionListener(ActionListener al) {
            create.addActionListener(al);
            createListenerCount++;
        }

        @Override
        public void addBackActionListener(ActionListener al) {
            back.addActionListener(al);
            backListenerCount++;
        }

        @Override
        public boolean confirmDialog(String title, String msg) {
            return true;
        }
    }
    
    private class ModelStub extends ManageUsersModel {
        int deleteCallCount = 0;
        
        public ModelStub(UserQueriesStub queryTool) {
            super(queryTool, queryTool.fetchPlannersMaintainers());
        }

        @Override
        public void delete(int index) {
            deleteCallCount++;
        }
    }
    
    ManageUsersController controller;
    ModelStub model;
    ViewStub view;
    NavigatorStub nav;
    
    @Before
    public void setUp() {
        nav = new NavigatorStub();
        model = new ModelStub(new UserQueriesStub());
        view = new ViewStub(nav, model);
        controller = new ManageUsersController(model, view);
    }
    
    @Test
    public void testRegisterListeners() {
        assertEquals(1, view.backListenerCount);
        assertEquals(1, view.createListenerCount);
        assertEquals(1, view.deleteListenerCount);
        assertEquals(1, view.editListenerCount);
    }
    
    @Test
    public void testBackListenerAction() {
        view.back.doClick();
        assertEquals(1, nav.getPopCallCount());
    }
    
    @Test
    public void testCreateListenerAction() {
        view.create.doClick();
        assertEquals(1, nav.getPushCallCount());
    }
    
    @Test
    public void testDeleteListenerAction() {
        view.deleteActionListener.actionPerformed(1);
        assertEquals(1, model.deleteCallCount);
    }
    
    @Test
    public void testEditListenerAction() {
        view.editActionListener.actionPerformed(1);
        assertEquals(1, nav.getPushCallCount());
    }
}
