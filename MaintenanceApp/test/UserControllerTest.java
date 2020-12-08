
/**
 *
 * @author giand
 */
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import org.junit.*;
import static org.junit.Assert.*;
import root.Navigator;
import root.Navigable;
import root.screens.createuser.UserController;
import root.screens.createuser.UserModel;
import root.screens.createuser.UserView;

public class UserControllerTest {
    
    private class UserViewStub extends UserView {
        JButton back = new JButton();
        JButton create = new JButton();  
        // counters of register calls
        int backListenerCount = 0;
        int createListenerCount = 0;
        
        public UserViewStub(Navigable nav) {
            super(nav);            
        } 
        
        @Override
        public void addCreateButtonListener(ActionListener al) {
            create.addActionListener(al);
            createListenerCount++;
        }

        @Override
        public void addBackButtonListener(ActionListener al) {
            back.addActionListener(al);
            backListenerCount++;
        }

    }

    private class UserModelStub extends UserModel {

        public UserModelStub() {
            super();
        }

    }

    private UserController uc;
    private UserViewStub uvs;
    private UserModelStub ums;

    @Before
    public void setUp() {
        ums = new UserModelStub();
        uvs = new UserViewStub(new Navigator("test",
                new UserControllerTest.UserBuilderStub()));
        uc = new UserController(ums,uvs);
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
