
import org.junit.*;
import static org.junit.Assert.*;
import root.Navigable;
import stubs.NavigatorStub;
import root.screens.modifyuser.*;

public class ModifyUserControllerTest {    
    
    private class ModifyUserViewStub extends ModifyUserView{
        
        private String name = "";
        private String surname = "";
        private String email = ""; 
        private String address = "";
        private String cf = "";
        private String username = "";
        private String password = "";
        private String role = "";
        
        private final ModifyUserModelStub model;
        
        private final javax.swing.JButton backBtn = new javax.swing.JButton();
        private final javax.swing.JButton modifyBtn = new javax.swing.JButton();
        
        int backListenerCount = 0;
        int modifyListenerCount = 0;
        
        public ModifyUserViewStub(Navigable nav, ModifyUserModelStub model){
            super(nav, model);
            this.model = model;
        }   

        @Override
        public String getNameInput() {
            return name;
        }

        public void setNameInput(String name) {
            this.name = name;
        }

        @Override
        public String getSurnameInput() {
            return surname;
        }

        public void setSurnameInput(String surname) {
            this.surname = surname;
        }

        @Override
        public String getEmailInput() {
            return email;
        }

        public void setEmailInput(String email) {
            this.email = email;
        }

        @Override
        public String getAddressInput() {
            return address;
        }

        public void setAddressInput(String address) {
            this.address = address;
        }

        @Override
        public String getCfInput() {
            return cf;
        }

        public void setCfInput(String cf) {
            this.cf = cf;
        }

        @Override
        public String getUsernameInput() {
            return username;
        }

        public void setUsernameInput(String username) {
            this.username = username;
        }

        @Override
        public String getPasswordInput() {
            return password;
        }

        public void setPasswordInput(String password) {
            this.password = password;
        }

        @Override
        public String getRoleInput() {
            return role;
        }

        public void setRoleInput(String role) {
            this.role = role;
        }
        
        @Override
        public void addBackButtonListener(java.awt.event.ActionListener al){
            backBtn.addActionListener(al);
            backListenerCount ++;
        }
        
        @Override
        public void addModifyButtonListener(java.awt.event.ActionListener al){
            modifyBtn.addActionListener(al);
            modifyListenerCount ++;
        }
        
        
    }
    
    private class ModifyUserModelStub extends ModifyUserModel{    
        public ModifyUserModelStub(String name, String surname, String cf, String email, String address, String username, String password, UserType role) {
            super(name, surname, cf, email, address, username, password, role);
        }
    }
    
    private ModifyUserViewStub viewStub;
    private ModifyUserModelStub modelStub;
    private ModifyUserController controller;
    private NavigatorStub navStub;
    
    @Before
    public void setUp(){
        modelStub = new ModifyUserModelStub(null, null, null,
            null, null, null, null, ModifyUserModelStub.UserType.valueOf("P"));
        viewStub = new ModifyUserViewStub(navStub, modelStub);
        controller = new ModifyUserController(viewStub, modelStub);
    }
    
    @Test
    public void testBackRegisterListener(){
        assertEquals(1, viewStub.backListenerCount);
    }
    
    @Test
    public void testModifyRegisterListener(){
        assertEquals(1, viewStub.modifyListenerCount);
    }
    
    @Test
    public void testCheckoutIdeal(){
        viewStub.setNameInput("John");
        viewStub.setSurnameInput("Doe");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setUsernameInput("JDoe");
        viewStub.setPasswordInput("superDoe");
        viewStub.setRoleInput("P");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertTrue(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutName(){
        viewStub.setSurnameInput("Doe");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setUsernameInput("JDoe");
        viewStub.setPasswordInput("superDoe");
        viewStub.setRoleInput("P");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertFalse(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutId(){
        viewStub.setNameInput("John");
        viewStub.setSurnameInput("Doe");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setUsernameInput("JDoe");
        viewStub.setPasswordInput("superDoe");
        viewStub.setRoleInput("P");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertFalse(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutSurname(){
        viewStub.setNameInput("John");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setUsernameInput("JDoe");
        viewStub.setPasswordInput("superDoe");
        viewStub.setRoleInput("P");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertFalse(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutAddress(){
        viewStub.setNameInput("John");
        viewStub.setSurnameInput("Doe");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setUsernameInput("JDoe");
        viewStub.setPasswordInput("superDoe");
        viewStub.setRoleInput("P");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertFalse(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutCf(){
        viewStub.setNameInput("John");
        viewStub.setSurnameInput("Doe");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setUsernameInput("JDoe");
        viewStub.setPasswordInput("superDoe");
        viewStub.setRoleInput("P");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertFalse(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutUsername(){
        viewStub.setNameInput("John");
        viewStub.setSurnameInput("Doe");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setPasswordInput("superDoe");
        viewStub.setRoleInput("P");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertFalse(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutPassword(){
        viewStub.setNameInput("John");
        viewStub.setSurnameInput("Doe");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setUsernameInput("JDoe");
        viewStub.setRoleInput("P");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertFalse(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutRole(){
        viewStub.setNameInput("John");
        viewStub.setSurnameInput("Doe");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setUsernameInput("JDoe");
        viewStub.setPasswordInput("superDoe");
        viewStub.setEmailInput("jdoe@email.com");
        
        assertFalse(controller.checkout());
    }
    
    @Test
    public void testCheckoutWithoutEmail(){
        viewStub.setNameInput("John");
        viewStub.setSurnameInput("Doe");
        viewStub.setAddressInput("Indirizzo");
        viewStub.setCfInput("JJJDDD00J00J000J");
        viewStub.setUsernameInput("JDoe");
        viewStub.setPasswordInput("superDoe");
        viewStub.setRoleInput("P");
        
        assertFalse(controller.checkout());
    }
    
}
