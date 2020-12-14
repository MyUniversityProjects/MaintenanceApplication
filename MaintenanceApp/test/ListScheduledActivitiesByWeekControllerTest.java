import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import queries.ActivityQueries;
import root.Navigable;
import root.screens.listscheduledactivitiesbyweek.ListScheduledActivitiesByWeekController;
import root.screens.listscheduledactivitiesbyweek.ListScheduledActivitiesByWeekModel;
import root.screens.listscheduledactivitiesbyweek.ListScheduledActivitiesByWeekView;
import stubs.NavigatorStub;
import ui.ButtonColumnActionListener;


public class ListScheduledActivitiesByWeekControllerTest {
    /*
    **Defining a Stub for the view of ListScheduledActivities
    */
    private class ViewStub extends ListScheduledActivitiesByWeekView {
        int scheduledActivityIndex = 3;
        Integer selectedItem = 89;
        JButton back = new JButton();
        ButtonColumnActionListener selectActionListener;
        JComboBox<Integer> numWeekBox = new JComboBox<>();
        // counters of register calls
        int selectListenerCount = 0;
        int backListenerCount = 0;
        int numWeekComboBoxListenerCount = 0;
        // counters of some action on the view
        int getSelectedScheduledActivityIndexCount = 0;
        int getSelectedComboBoxIntegerCount = 0;
        int toThePreviousScreenCount = 0;
        
        public ViewStub(Navigable nav, ModelStub model) {
            super(nav, model);
        }

        @Override
        public void addBackButtonListener(ActionListener al) {
            back.addActionListener(al);
            backListenerCount++;
        }
    
        @Override
        public void addNumWeeKBoxListener(ActionListener al) {
            numWeekBox.addActionListener(al);
            numWeekComboBoxListenerCount++;
        } 

        @Override
        public void setSelectButtonListener(ButtonColumnActionListener al) {
            selectActionListener = al;
            selectListenerCount++;
        }

        @Override
        public void toThePreviousScreen(){
            toThePreviousScreenCount++;
            nav.pop();
        }

        @Override
        public int getSelectedScheduledActivityIndex(){
            getSelectedScheduledActivityIndexCount++;
            return scheduledActivityIndex;
        }

        @Override
        public Integer getSelectedComboBoxInteger(){
            getSelectedComboBoxIntegerCount++;
            return selectedItem;
            
        }
    }
    /*
    **Defining a Stub for the model of ListScheduledActivities
    */
    private class ModelStub extends ListScheduledActivitiesByWeekModel {
        int getSelectedActivityCount = 0;
        public ModelStub(ActivityQueries query) throws SQLException {
            super(query);
        }
        @Override
        public int getSelectedActivity(int index){
            getSelectedActivityCount++;
            return 1;
        }
        
    }
    
    private class ActivityQueriesStub extends ActivityQueries{
        public ActivityQueriesStub() {
            super();
        }
    }
    ListScheduledActivitiesByWeekController controller;
    ViewStub view;
    ModelStub model;
    NavigatorStub nav;
    ActivityQueriesStub query;
             
    @Before
    public void setUp() throws SQLException {
        nav = new NavigatorStub();
        query = new ActivityQueriesStub();
        model = new ModelStub(query);
        view = new ViewStub(nav, model);
        controller = new ListScheduledActivitiesByWeekController(view, model);
    }
    
    @Test
    public void testRegisterListeners() {
        assertEquals(1, view.selectListenerCount);
        assertEquals(1, view.numWeekComboBoxListenerCount);
        assertEquals(1, view.backListenerCount);
    }
    
    @Test
    public void testBackListenerAction() {
        view.back.doClick();
        assertEquals(1, view.toThePreviousScreenCount);
        assertEquals(1, nav.getPopCallCount());
    }    
}
