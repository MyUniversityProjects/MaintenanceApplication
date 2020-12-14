/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import root.Navigable;
import root.Navigator;
import root.Screen;
import root.entities.Activity;
import root.screenbuilders.ScreenBuilder;
import root.screens.assignactivity.AssignActivityControllerMokeUp2;
import root.screens.assignactivity.AssignActivityModel;
import root.screens.assignactivity.AssignActivityView;
import queries.ActivityQueries;
/**
 *
 * @author lex99
 */
public class AssignActivityTest {
    
    
    private class AssignActivityBuilderStub extends ScreenBuilder{
        
        AssignActivityViewStub view;
        
        @Override
        public void buildView(Navigable nav) {
            try {
                view = new AssignActivityViewStub(nav);
            } catch (SQLException ex) {
                Logger.getLogger(AssignActivityTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public Screen getScreen() {
            return view;
        }
    }

    private class AssignActivityViewStub extends AssignActivityView {
             
        public AssignActivityViewStub(Navigable nav) throws SQLException {
            super(nav);            
        }              
    }
    
    private class AssignActivityControllerStub extends AssignActivityControllerMokeUp2 {
        public AssignActivityControllerStub(AssignActivityView view, AssignActivityModel model, int activityID, String cf) throws SQLException {
            super(view, model, activityID, 7, cf);
        }
    }

    private class AssignActivityModelStub extends AssignActivityModel {

        public AssignActivityModelStub() throws SQLException {
            super();
        }

    }
    
    private AssignActivityView view;
    private AssignActivityControllerStub controller1;
    private AssignActivityControllerStub controller2;
    private AssignActivityControllerStub controller3;
    private AssignActivityControllerStub controller4;
    private AssignActivityModelStub model;
    
    private ActivityQueries query;
    
    
    @Before
    public void setUp() throws SQLException {
        query = new ActivityQueries();
             
        Activity a1 = new Activity(9999991, "informatica", "sede centrale",
            "elettrica", "Il lavoro consiste nel sostituire una lampadina",
            90, true, 50, "ciao", Activity.ActivityType.PLANNED);
        query.create(a1);
        
        Activity a2 = new Activity(9999992, "informatica", "sede centrale",
            "elettrica", "Il lavoro consiste nel sostituire una lampadina",
            10, true, 50, "ciao", Activity.ActivityType.PLANNED);
        query.create(a2);
        
        Activity a3 = new Activity(9999992, "informatica", "sede centrale",
            "elettrica", "Il lavoro consiste nel sostituire una lampadina",
            40, true, 50, "ciao", Activity.ActivityType.PLANNED);
        query.create(a3);
        
        Activity a4 = new Activity(9999992, "informatica", "sede centrale",
            "elettrica", "Il lavoro consiste nel sostituire una lampadina",
            1, true, 50, "ciao", Activity.ActivityType.PLANNED);
        query.create(a4);
        
        
        view = new AssignActivityViewStub(new Navigator("test",
                new AssignActivityBuilderStub()));
        model = new AssignActivityModelStub();
        
        controller1 =  new AssignActivityControllerStub(view, model, 9999991, "TTTTTT11T11T111T");
        controller2 = new AssignActivityControllerStub(view, model, 9999994, "TTTTTT22T22T222T");
        controller3 = new AssignActivityControllerStub(view, model, 9999993, "TTTTTT11T11T111T");
        
    }
    
    
    @Test
    public void test1() throws SQLException {
        int result = controller1.assignActivity(4, 9999991, "TTTTTT11T11T111T", "50", 7);
        assertEquals(0, result);
    }
    
    @Test
    public void test2() throws SQLException {
        int result = controller3.assignActivity(2, 9999993, "TTTTTT11T11T111T", "50", 7);
        assertEquals(-1, result);
        
    }
    
    @Test
    public void test3() throws SQLException {
        int result = controller2.assignActivity(3, 9999994, "TTTTTT22T22T222T", "50", 7);
        assertEquals(1, result);
        model.removeAssign("TTTTTT22T22T222T", 9999994);
    }
    
    
    @Test
    public void test4() throws SQLException {
        int result = controller3.assignActivity(3, 9999993, "TTTTTT11T11T111T", "50", 7);
        assertEquals(-2, result);
    }
    
    
    
    
    
    
        
       
    
    
        
    
    
}
