
import root.screens.createactivity.ActivityController;
import root.screens.createactivity.ActivityModel;
import root.screens.createactivity.ActivityView;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import queries.ActivityQueries;
import root.Navigator;
import root.Navigable;
import root.Screen;
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
            super(new ActivityQueries());
        }

    }

    private ActivityController ac;
    private ActivityViewStub avs;
    private ActivityModelStub ams;
    public Map<String, String> inputTest;

    @Before
    public void setUp() {
        ams = new ActivityModelStub();
        avs = new ActivityViewStub(new Navigator("test",
                new ActivityControllerTest.ActivityBuilderStub()));
        ac = new ActivityController(ams, avs);
        inputTest = new HashMap<>();
    }

    @Test
    public void testCreateCheckoutIdeal() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertTrue(ac.createCheckout(inputTest));
    }

    @Test
    public void testCreateCheckoutWithIdNotValid() {        

        inputTest.put("id", "x");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "yes");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");

        assertFalse(ac.createCheckout(inputTest));
    }
    
     @Test
    public void testCreateCheckoutWithoutId() {        

        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertFalse(ac.createCheckout(inputTest));
    }

    @Test
    public void testCreateCheckoutWithoutBranchOffice() {        

        inputTest.put("id", "1");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "yes");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithoutArea() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithoutTime() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithoutInterruptible() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithoutTypology() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithoutWeek() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithoutNotes() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");       

        assertTrue(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithoutDescription() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("type", "scheduled");       

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithouType() {        

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "true");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");      

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithNegativeTime(){  

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "-60");
        inputTest.put("interruptible", "yes");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");    

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithNegativeWeel(){         

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "yes");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "-17");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");    

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithSubOutRangeWeek(){         

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "yes");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "0");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");
        inputTest.put("type", "scheduled");    

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testCreateCheckoutWithOverOutRangeWeek(){         

        inputTest.put("id", "1");
        inputTest.put("branch_office", "sede centrale");
        inputTest.put("area", "informatica");
        inputTest.put("estimated_time", "60");
        inputTest.put("interruptible", "yes");
        inputTest.put("typology", "elettrica");
        inputTest.put("week", "53");
        inputTest.put("notes", "ciao");
        inputTest.put("description", "Il lavoro consiste nel"
                + " sostituire una lampadina");

        assertFalse(ac.createCheckout(inputTest));
    }
    
    @Test
    public void testValidateIdCorrect(){
        assertTrue(ac.validateId("10"));
    }
    
    @Test
    public void testValidateIdWithNegativeValue(){
        assertFalse(ac.validateId("-10"));
    }
    
    @Test
    public void testValidateIdWithAlphaValue(){
        assertFalse(ac.validateId("10a"));
    }
    
    @Test
    public void testValidateTimeCorrect(){
        assertTrue(ac.validateTime("10"));
    }
    
    @Test
    public void testValidateTimeWithNegativeValue(){
        assertFalse(ac.validateTime("-10"));
    }
    
    @Test
    public void testValidateTimeWithAlphaValue(){
        assertFalse(ac.validateTime("10a"));
    }
    
    @Test
    public void testValidateWeekCorrect(){
        assertTrue(ac.validateWeek("10"));
    }
    
    @Test
    public void testValidateWeekWithNegativeValue(){
        assertFalse(ac.validateWeek("-10"));
    }
    
    @Test
    public void testValidateWeekWithSubRangeValue(){
        assertFalse(ac.validateWeek("0"));
    }
    
    @Test
    public void testValidateWeekWithOverRangeValue(){
        assertFalse(ac.validateWeek("53"));
    }
    
}
