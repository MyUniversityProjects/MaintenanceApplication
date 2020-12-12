import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import queries.ActivityQueries;
import root.Navigable;
import root.entities.Activity;
import root.screens.modifyselectedactivity.ModifySelectedActivityController;
import root.screens.modifyselectedactivity.ModifySelectedActivityModel;
import root.screens.modifyselectedactivity.ModifySelectedActivityView;
import stubs.NavigatorStub;


public class ModifySelectedActivityControllerTest {
    /*Defining a Stub of a View for testing purpose*/
    private class ViewStub extends ModifySelectedActivityView {
        JButton back = new JButton();
        JButton home = new JButton();
        JButton modify = new JButton();
        String id = "1";
        String branchOffice = "Fisciano";
        String area = "Molding";
        String estimatedTime = "120";
        String interruptible = "true";
        String typology = "idraulica";
        String week = "1";
        String notes = "Note";
        String description = "Descrizione attività";
        
        // counters of register calls
        int backListenerCount = 0;
        int homeListenerCount = 0;
        int modifyListenerCount = 0;
        // counters of some action on the view
        int getInputsCount = 0;
        
        
        // Used to see the success of the modify operation
        boolean result = false;
        
        public ViewStub(Navigable nav, ModelStub model) {
            super(nav, model);
        }

 
        @Override
        public void addHomeButtonListener(ActionListener al) {
            home.addActionListener(al);
            homeListenerCount++;
        }


        @Override
        public void addBackButtonListener(ActionListener al) {
            back.addActionListener(al);
            backListenerCount++;
        }
         
        @Override
        public void addModifyButtonListener(ActionListener al) {
            modify.addActionListener(al);
            modifyListenerCount++;
        }

        @Override
        public String getId(){
            return id;
        }

        @Override
        public String getBranchOffice(){
            return branchOffice;
        }

        @Override
        public String getArea(){
            return area;
        }

        @Override
        public String getEstimatedTime(){
            return estimatedTime;
        }

        @Override
        public String getInterruptible(){
            return interruptible;
        }

        @Override
        public String getTypology(){
            return typology;
        }

        @Override
        public String getWeek(){
            return week;
        }

        @Override
        public String getNotes(){
            return notes;
        }

        @Override
        public String getDescription(){
            return description;
        }

        @Override
        public void showMsg(String title, String msg) {
            result = true;
        }

        @Override
        public void showErrorMsg(String title, String msg) {
            result = false;
        }

    }
    /*Defining a Stub of a Model for testing purpose*/
    private class ModelStub extends ModifySelectedActivityModel {
        int modifyCallCount = 0;
        
        public ModelStub(ActivityQueries query) {
            super(new Activity(1, null, null, null, null, 1, true, 1, null, null),query);
        }

        @Override
        public boolean modify(Map<String, String> inputMap){
            modifyCallCount++;
            return true;
        }
    }
    
    private class ActivityQueriesStub extends ActivityQueries{
        public ActivityQueriesStub() {
            super();
        }
    }
    
    ActivityQueriesStub query;
    ModifySelectedActivityController controller;
    ViewStub view;
    ModelStub model;
    NavigatorStub nav;
    
    @Before
    public void setUp() {
        nav = new NavigatorStub();
        query = new ActivityQueriesStub();
        model = new ModelStub(query);
        view = new ViewStub(nav, model);
        controller = new ModifySelectedActivityController(model, view);
    }
    
    @Test
    public void testRegisterListeners() {
        assertEquals(1, view.backListenerCount);
        assertEquals(1, view.homeListenerCount);
        assertEquals(1, view.modifyListenerCount);
    }
    

    @Test
    public void testBackListenerAction() {
        view.back.doClick();
        assertEquals(1, nav.getPopCallCount());
    }
    
    @Test
    public void testHomeListenerAction() {
        view.home.doClick();
        assertEquals(1, nav.getHomeCallCount());
    }
    
    @Test
    public void testmodifyListenerAction() {
        assertEquals(0, model.modifyCallCount);
        view.modify.doClick();
        assertEquals(1, model.modifyCallCount);
        assertTrue(view.result);
    }
    
    @Test
    public void testModifyCheckoutKeyListNotContainsAll() {
        view.branchOffice = "";
        view.modify.doClick();
        assertFalse(view.result);
    }
    
    @Test
    public void testModifyCheckoutTimeNotANumber() {
        view.estimatedTime = "NotTime";
        view.modify.doClick();
        assertFalse(view.result);
    }
    @Test
    public void testModifyCheckoutNoteEmpty() {
        view.notes = ""; 
        assertEquals(0, model.modifyCallCount);
        view.modify.doClick();
        assertEquals(1, model.modifyCallCount);
        assertTrue(view.result);
    }

}
