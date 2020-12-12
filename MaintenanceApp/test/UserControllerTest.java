
/**
 *
 * @author giand
 */
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import org.junit.*;
import static org.junit.Assert.*;
import root.Navigable;
import root.screens.createuser.User;
import root.screens.createuser.UserController;
import root.screens.createuser.UserModel;
import root.screens.createuser.UserQueries;
import root.screens.createuser.UserView;
import stubs.NavigatorStub;

public class UserControllerTest {
    /*
    * Stub used to simulute the view 
    */
    private class UserViewStub extends UserView {
        JButton back = new JButton();
        JButton create = new JButton();  
        // counters of register calls
        int backListenerCount = 0;
        int createListenerCount = 0;
        // attribute to simulate the inputs from the user
        private String address;
        private String email;
        private String surname;
        private String name;
        private String role;
        private String password;
        private String username;
        private String cf;
        
        // Attribute for testing purpose
        private boolean result;
        
        public UserViewStub(Navigable nav) {
            super(nav);
        } 

        public void setAddress(String address) {
            this.address = address;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setCf(String cf) {
            this.cf = cf;
        }

        @Override
        public String getAddress() {
            return address; 
        }

        @Override
        public String getEmail() {
            return email;
        }

        @Override
        public String getSurname() {
            return surname;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getRole() {
            return role;
        }

        @Override
        public String getPassword() {
            return password; 
        }

        @Override
        public String getUsername() {
            return username; 
        }

        @Override
        public String getCf() {
            return cf; 
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
        /**
         * method override for testing purpose
         * This fuction is only called in the controller in case 
         * the create ended successful
         * 
         * @param title 
         * @param msg 
         */
        @Override
        public void showMsg(String title, String msg) {
            result = true;
        }

        /**
         * method override for testing purpose
         * This fuction is only called in the controller in case 
         * the create has given an error
         * 
         * @param title
         * @param msg 
         */
        @Override
        public void showErrorMsg(String title, String msg) {
            result = false;
        }

    }
    /**
     * Used to simulute the interaction between the model and the database
     * 
     */
    private class UserQueriesStub extends UserQueries{
        private ArrayList<String> userCfList = new ArrayList<String>();
        private ArrayList<String> userUsernameList = new ArrayList<String>();
        
        /**
         * the following override simulate the 
         * query of an insert of a user in the database
         * 
         * @param user
         * @return 
         */ 
        @Override
        public boolean insertIntoAppUser(User user){
            if(userCfList.contains(user.getCf()) && userUsernameList.contains(user.getUsername())){
                return false;
            }else{
                userCfList.add(user.getCf());
                userUsernameList.add(user.getUsername());
                return true;
            }
        }
    }
    

    /**
     * Stub used to the model
     */
    private class UserModelStub extends UserModel {
        private UserQueriesStub createUserQueriesStub;
        
        public UserModelStub() {
            super();
            createUserQueriesStub = new UserQueriesStub();
        }

        @Override
        public boolean create(User user) {
            return createUserQueriesStub.insertIntoAppUser(user); 
        }
        
    }

    private UserViewStub viewStub;
    private UserModelStub modelStub;
    private UserController controller;
    private UserQueriesStub queryStub;
    
    private NavigatorStub navStub;
    
    
    @Before
    public void setUp(){
        modelStub = new UserModelStub();
        viewStub = new UserViewStub(navStub);
        controller = new UserController(modelStub, viewStub);
    }
    /**
     * Testing if the BackButtonListener is correctly added
     */
    @Test
    public void testBackRegisterListener(){
        assertEquals(1, viewStub.backListenerCount);
    }
    
    /**
     * Testing if the CreateButtonListener is correctly added
     */   
    @Test
    public void testCreateRegisterListener(){
        assertEquals(1, viewStub.createListenerCount);
    }
   
    /**
     * Testing a case of ideal create
     */
    @Test
    public void testCreateCheckoutIdeal() {
        viewStub.setCf("GRRLMO09E21L219M");
        viewStub.setUsername("OLMO");
        viewStub.setPassword("sadasdhjqwdoklkòsd");
        viewStub.setRole("P");
        viewStub.setName("OLMO");
        viewStub.setSurname("GUERRA");
        viewStub.setEmail("olm@gmail.com");
        viewStub.setAddress("Avellino Via roma");
        viewStub.create.doClick();
        assertTrue(viewStub.result);
    }
    
    /**
     * Testing the case of void inputs
     */
    @Test
    public void testCreateCheckoutVoidInputs() {
        viewStub.setCf("");
        viewStub.setUsername("");
        viewStub.setPassword("");
        viewStub.setRole("P");
        viewStub.setName("");
        viewStub.setSurname("");
        viewStub.setEmail("");
        viewStub.setAddress("");
        viewStub.create.doClick();
        assertFalse(viewStub.result);
    }
    
    /**
     *  Testing the case of a void passwordInput
     */
    @Test
    public void testCreateCheckoutVoidPasswordInput() {
        viewStub.setCf("FLLLMO09E21L219M");
        viewStub.setUsername("OLMO");
        viewStub.setPassword("");
        viewStub.setRole("P");
        viewStub.setName("OLMO");
        viewStub.setSurname("GUERRA");
        viewStub.setEmail("olm@gmail.com");
        viewStub.setAddress("Avellino Via roma");
        viewStub.create.doClick();
        assertFalse(viewStub.result);
    }

    /**
     *  Testing the case of a void cfInput
     */
    @Test
    public void testCreateCheckoutVoidCfInput() {
        viewStub.setCf("");
        viewStub.setUsername("OLMO1");
        viewStub.setPassword("sadasdhjqwdoklkòsd");
        viewStub.setRole("P");
        viewStub.setName("OLMO");
        viewStub.setSurname("GUERRA");
        viewStub.setEmail("olm@gmail.com");
        viewStub.setAddress("Avellino Via roma");
        viewStub.create.doClick();
        assertFalse(viewStub.result);
    }
    
    /**
     *  Testing the case of a void usernameInput
     */
    @Test
    public void testCreateCheckoutVoidUsernameInput() {
        viewStub.setCf("GRRTPO09E21L219M");
        viewStub.setUsername("");
        viewStub.setPassword("sadasdhjqwdoklkòsd");
        viewStub.setRole("P");
        viewStub.setName("OLMO");
        viewStub.setSurname("GUERRA");
        viewStub.setEmail("olm@gmail.com");
        viewStub.setAddress("Avellino Via roma");
        viewStub.create.doClick();
        assertFalse(viewStub.result);
    }
    
    /**
     *  Testing the case of a void namefInput
     */
    @Test
    public void testCreateCheckoutVoidNameInput() {
        viewStub.setCf("GRRTPO09E21L219M");
        viewStub.setUsername("OLMO2");
        viewStub.setPassword("sadasdhjqwdoklkòsd");
        viewStub.setRole("P");
        viewStub.setName("");
        viewStub.setSurname("GUERRA");
        viewStub.setEmail("olm@gmail.com");
        viewStub.setAddress("Avellino Via roma");
        viewStub.create.doClick();
        assertFalse(viewStub.result);
    }
    
    /**
     *  Testing the case of a void surnameInput
     */
    @Test
    public void testCreateCheckoutVoidSurnameInput() {
        viewStub.setCf("GTTTPO09E21L219M");
        viewStub.setUsername("OLMO3");
        viewStub.setPassword("sadasdhjqwdoklkòsd");
        viewStub.setRole("P");
        viewStub.setName("OLMO");
        viewStub.setSurname("");
        viewStub.setEmail("olm@gmail.com");
        viewStub.setAddress("Avellino Via roma");
        viewStub.create.doClick();
        assertFalse(viewStub.result);
    }
    
    /**
     *  Testing the case of a void emailInput
     */
    @Test
    public void testCreateCheckoutVoidEmailInput() {
        viewStub.setCf("GRRTPO04E11L119M");
        viewStub.setUsername("OLMO4");
        viewStub.setPassword("sadasdhjqwdoklkòsd");
        viewStub.setRole("P");
        viewStub.setName("OLMO");
        viewStub.setSurname("Tenagi");
        viewStub.setEmail("");
        viewStub.setAddress("Avellino Via roma");
        viewStub.create.doClick();
        assertFalse(viewStub.result);
    }
    
    /**
     *  Testing the case of a void addressInput
     */
    @Test
    public void testCreateCheckoutVoidAddressInput() {
        viewStub.setCf("GRRTPO04E11L320M");
        viewStub.setUsername("OLMO5");
        viewStub.setPassword("sadasdhjqwdoklkòsd");
        viewStub.setRole("P");
        viewStub.setName("OLMO");
        viewStub.setSurname("GUERRA");
        viewStub.setEmail("olm@gmail.com");
        viewStub.setAddress("");
        viewStub.create.doClick();
        assertFalse(viewStub.result);
    }
}
