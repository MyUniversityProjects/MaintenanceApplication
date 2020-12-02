/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import root.Navigable;
import root.Navigator;
import root.Screen;
import root.entities.Activity;
import root.screenbuilders.ScreenBuilder;
import root.screens.assignactivity.AssignActivityController;
import root.screens.assignactivity.AssignActivityModel;
import root.screens.assignactivity.AssignActivityView;
import root.screens.manageactivity.ManageActivityModel;
import root.screens.createactivity.ActivityController;
import root.screens.createactivity.ActivityModel;
import root.screens.createactivity.ActivityView;
import stubs.NavigatorStub;
import org.junit.AfterClass;
/**
 *
 * @author lex99
 */
public class AssignActivityTest {
    
    
    

    private class AssignActivityViewStub extends AssignActivityView {
             
        public AssignActivityViewStub(Navigable nav, int activityID, int day, String cf) throws SQLException {
            super(nav, activityID, day, cf);            
        }              
    }
    
    private class AssignActivityControllerStub extends AssignActivityController {
        public AssignActivityControllerStub(int activityId, String cf, int day) throws SQLException {
            super(activityId, cf, day);
        }
    }

    private class AssignActivityModelStub extends AssignActivityModel {

        public AssignActivityModelStub() throws SQLException {
            super();
        }

    }
    
    private class ActivityBuilderStub extends ScreenBuilder{
        
        ActivityViewStub view;
        
        @Override
        public void buildView(Navigable nav) {
            view = new ActivityViewStub(nav);
        }

        @Override
        public Screen getScreen() {
            return view;
        }
    }

    private class ActivityViewStub extends ActivityView {
             
        public ActivityViewStub(Navigable nav) {
            super(nav);            
        }              
    }

    private class ActivityModelStub extends ActivityModel {

        public ActivityModelStub() {
            super();
        }

    }
    
    private AssignActivityControllerStub controller1;
    private AssignActivityControllerStub controller2;
    private AssignActivityControllerStub controller3;
    private AssignActivityControllerStub controller4;
    private AssignActivityModelStub model;
    
    private ActivityViewStub activityView;
    private ActivityModelStub activityModel;
    private ActivityController activityController; 
    private ManageActivityModel manageModel;
    
    
    @Before
    public void setUp() throws SQLException {
        activityModel = new ActivityModelStub();
        activityView = new ActivityViewStub(new Navigator("test",
                new ActivityBuilderStub()));
        activityController = new ActivityController(activityModel, activityView); 
        manageModel = new ManageActivityModel();
        
        Map<String, String> inputTest1 = new HashMap<>();
        Map<String, String> inputTest2 = new HashMap<>();
        Map<String, String> inputTest3 = new HashMap<>();
        Map<String, String> inputTest4 = new HashMap<>();
        
        

        inputTest1.put("id", "9999991");
        inputTest1.put("branch_office", "sede centrale");
        inputTest1.put("area", "informatica");
        inputTest1.put("estimated_time", "90");
        inputTest1.put("interruptible", "true");
        inputTest1.put("typology", "elettrica");
        inputTest1.put("week", "50");
        inputTest1.put("notes", "ciao");
        inputTest1.put("description", "Il lavoro consiste nel sostituire una lampadina");
        inputTest1.put("type", "PLANNED");      
        Activity a1 = activityController.createActivity(inputTest1);
        activityModel.create(a1);
        
        inputTest2.put("id", "9999992");
        inputTest2.put("branch_office", "sede centrale");
        inputTest2.put("area", "informatica");
        inputTest2.put("estimated_time", "10");
        inputTest2.put("interruptible", "true");
        inputTest2.put("typology", "elettrica");
        inputTest2.put("week", "50");
        inputTest2.put("notes", "ciao");
        inputTest2.put("description", "Il lavoro consiste nel sostituire una lampadina");
        inputTest2.put("type", "PLANNED");      
        Activity a2 = activityController.createActivity(inputTest2);
        activityModel.create(a2);
        
        inputTest3.put("id", "9999993");
        inputTest3.put("branch_office", "sede centrale");
        inputTest3.put("area", "informatica");
        inputTest3.put("estimated_time", "40");
        inputTest3.put("interruptible", "true");
        inputTest3.put("typology", "elettrica");
        inputTest3.put("week", "50");
        inputTest3.put("notes", "ciao");
        inputTest3.put("description", "Il lavoro consiste nel sostituire una lampadina");
        inputTest3.put("type", "PLANNED");      
        Activity a3 = activityController.createActivity(inputTest3);
        activityModel.create(a3);
        
        inputTest4.put("id", "9999994");
        inputTest4.put("branch_office", "sede centrale");
        inputTest4.put("area", "informatica");
        inputTest4.put("estimated_time", "1");
        inputTest4.put("interruptible", "true");
        inputTest4.put("typology", "elettrica");
        inputTest4.put("week", "50");
        inputTest4.put("notes", "ciao");
        inputTest4.put("description", "Il lavoro consiste nel sostituire una lampadina");
        inputTest4.put("type", "PLANNED");      
        Activity a4 = activityController.createActivity(inputTest4);
        activityModel.create(a4);
        
        
        controller1 = new AssignActivityControllerStub(9999991, "TEST1TEST1TEST11", 7);
        controller2 = new AssignActivityControllerStub(9999994, "TESTTESTTEST2222", 7);
        controller3 = new AssignActivityControllerStub(9999993, "TEST1TEST1TEST11", 7);
        
        
        
    }
    
    
    @Test
    public void test1() throws SQLException {
        System.out.println("test1");
        int result = controller1.assignActivity(4, "50");
        assertEquals(0, result);
    }
    
    @Test
    public void test2() throws SQLException {
        int result = controller3.assignActivity(2,"50");
        assertEquals(-1, result);
    }
    
    @Test
    public void test3() throws SQLException {
        int result = controller2.assignActivity(3,"50");
        assertEquals(1, result);
    }
    
    
    @Test
    public void test4() throws SQLException {
        int result = controller3.assignActivity(3,"50");
        assertEquals(-2, result);
    }
    
    
    
    
    
    
        
       
    
    
        
    
    
}
