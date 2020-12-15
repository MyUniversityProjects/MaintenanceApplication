import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import queries.ActivityQueries;
import queries.MaterialQueries;
import root.Navigable;
import root.entities.Activity;
import root.screens.modifyselectedactivity.ModifySelectedActivityController;
import root.screens.modifyselectedactivity.ModifySelectedActivityModel;
import root.screens.modifyselectedactivity.ModifySelectedActivityView;
import stubs.*;
import ui.ListFillModel;


public class ModifySelectedActivityControllerTest {
    /*Defining a Stub of a View for testing purpose*/
    private class ViewStub extends ModifySelectedActivityView {
        JButton back = new JButton();
        JButton home = new JButton();
        JButton modify = new JButton();
        JButton addMaterial = new JButton();
        JButton remMaterial = new JButton();
        String id = "1";
        String branchOffice = "Fisciano";
        String area = "Molding";
        String estimatedTime = "120";
        String interruptible = "true";
        String week = "1";
        String notes = "Note";
        String description = "Descrizione attività";
        
        // counters of register calls
        int backListenerCount = 0;
        int homeListenerCount = 0;
        int modifyListenerCount = 0;
        int remMaterialListenerCount = 0;
        int addMaterialListenerCount = 0;
        
        
        // Used to see the success of the modify operation
        boolean result = false;
        
        public ViewStub(Navigable nav, ModelStub model) {
            super(nav, model);
        }

        @Override
        public void addMaterialRemoveBtnListener(ActionListener al) {
            remMaterial.addActionListener(al);
            remMaterialListenerCount++;
        }

        @Override
        public void addMaterialAddBtnListener(ActionListener al) {
            addMaterial.addActionListener(al);
            addMaterialListenerCount++; 
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
        int addMaterialCallCount = 0;
        int removeMaterialCallCount = 0;
        int updateMaterialsToActivityCallCount = 0;
        
        String typology = "idraulica";
        
        public ModelStub(ActivityQueries query) {
            super(new ActivityQueriesStub().fetchComplete(1), new ActivityQueriesStub(),new MaterialQueriesStub().fetchAll());
        }

        @Override
        public void removeSelectedMaterial() {
            removeMaterialCallCount++;
        }

        @Override
        public void addSelectedMaterial() {
            addMaterialCallCount++;
        }
        
        @Override
        public boolean modify(Map<String, String> inputMap){
            modifyCallCount++;
            return true;
        }

        @Override
        public String getTypology() {
            return typology;
        }

        
        @Override
        public boolean updateMaterialsToActivity(int id) {
            updateMaterialsToActivityCallCount++;
            return true;
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
        assertEquals(1, view.remMaterialListenerCount);
        assertEquals(1, view.addMaterialListenerCount);
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
    public void testModifyCheckoutBranchOfficeInputVoid() {
        view.branchOffice = "";
        view.modify.doClick();
        assertFalse(view.result);
    }
    
    @Test
    public void testModifyCheckoutAreaInputVoid() {
        view.area = "";
        view.modify.doClick();
        assertFalse(view.result);
    }
    
    @Test
    public void testModifyCheckoutEstimatedTimeInputVoid() {
        view.estimatedTime = "";
        view.modify.doClick();
        assertFalse(view.result);
    }
    
    @Test
    public void testModifyCheckoutInterruptibleError() {
        view.interruptible = "";
        view.modify.doClick();
        assertFalse(view.result);
    }
    
    @Test
    public void testModifyCheckoutDescriptionInputVoid() {
        view.description = "";
        view.modify.doClick();
        assertFalse(view.result);
    }
    
    @Test
    public void testModifyCheckoutTypologyError() {
        model.typology = "";
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
