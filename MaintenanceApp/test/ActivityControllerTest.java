
import root.screens.createactivity.ActivityController;
import root.screens.createactivity.ActivityModel;
import root.screens.createactivity.ActivityView;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import root.Navigator;
import root.Navigable;
import root.Screen;
import root.entities.Activity;
import root.screenbuilders.ScreenBuilder;

public class ActivityControllerTest {
    
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

    private ActivityController ac;
    private ActivityViewStub avs;
    private ActivityModelStub ams;

    @Before
    public void setUp() {
        ams = new ActivityModelStub();
        avs = new ActivityViewStub(new Navigator("test",
                new ActivityControllerTest.ActivityBuilderStub()));
        ac = new ActivityController(ams, avs);
    }

    @Test
    public void testCreateCheckout1() {
        Map<String, String> inputTest = new HashMap<>();

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertTrue(ac.createCheckout(inputTest));
    }

    @Test
    public void testCreateCheckout2() {
        Map<String, String> inputTest = new HashMap<>();

        inputTest.put("id", "x");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "yes");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel sostituire una lampadina");

        assertFalse(ac.createCheckout(inputTest));
    }

    @Test
    public void testCreateCheckout3() {
        Map<String, String> inputTest = new HashMap<>();

        inputTest.put("id", "1");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "yes");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel sostituire una lampadina");

        assertFalse(ac.createCheckout(inputTest));
    }

}
