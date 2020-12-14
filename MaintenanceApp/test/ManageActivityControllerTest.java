import ui.ButtonColumnActionListener;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import root.Navigable;
import root.screens.manageactivity.*;
import stubs.ActivityQueriesStub;
import stubs.NavigatorStub;

public class ManageActivityControllerTest {
    private class ViewStub extends ManageActivityView {
        JButton back = new JButton();
        JButton plan = new JButton();
        ButtonColumnActionListener deleteActionListener;
        ButtonColumnActionListener editActionListener;        
        // counters of register calls
        int backListenerCount = 0;
        int createListenerCount = 0;
        int deleteListenerCount = 0;
        int editListenerCount = 0;
        
        public ViewStub(Navigable nav, ManageActivityModel model) {
            super(nav, model);
        }

        @Override
        public void setEditActivityButtonListener(ButtonColumnActionListener al) {
            editActionListener = al;
            editListenerCount++;
        }

        @Override
        public void setDeleteActivityButtonListener(ButtonColumnActionListener al) {
            deleteActionListener = al;
            deleteListenerCount++;
        }

        @Override
        public void addPlanActivityButtonListener(ActionListener al) {
            plan.addActionListener(al);
            createListenerCount++;
        }

        @Override
        public void addBackButtonListener(ActionListener al) {
            back.addActionListener(al);
            backListenerCount++;
        }
    }
    
    private class ModelStub extends ManageActivityModel {
        int deleteCallCount = 0;
        
        public ModelStub(ActivityQueriesStub queryTool) {
            super(queryTool);
        }

        @Override
        public boolean delete(int index) {
            deleteCallCount++;
            return true;
        }
    }
    
    ManageActivityController controller;
    ModelStub model;
    ViewStub view;
    NavigatorStub nav;
    
    @Before
    public void setUp() {
        nav = new NavigatorStub();
        model = new ModelStub(new ActivityQueriesStub());
        view = new ViewStub(nav, model);
        controller = new ManageActivityController(model, view);
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
        view.plan.doClick();
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
