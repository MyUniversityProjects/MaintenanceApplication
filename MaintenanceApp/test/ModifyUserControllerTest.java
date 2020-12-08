
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import root.Navigable;
import root.exceptions.NotFoundException;
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
    
    private class UserQueriesStub extends UserQueries{
        
        private final List<String> cfList = Arrays.asList(new String[] {"AAAAAA00A00A000A",
            "BBBBBB00B00B000B", "CCCCCC00C00C000C", "DDDDDD00D00D000D"});
        
        @Override
        public User getUser(String cf){
            if(cfList.contains(cf)){
                return new User("", "", cf, "", "", "", "", User.UserType.P);
            } else {
                return null;
            }                 
        }
        
        @Override
        public boolean modify(User user){
            return cfList.contains(user.getInitCf());
        }
    }
    
    private class ModifyUserModelStub extends ModifyUserModel{  
        
        private UserQueries queryStub;
        
        public ModifyUserModelStub(String name, String surname, String cf,
                String email, String address, String username,
                String password, UserType role, UserQueries query) {
            super(name, surname, cf, email, address, username,
                password, role, query);
            queryStub = query;
        }
        
        public UserQueries getQuery(){
            return queryStub;
        }
    }
    
    private ModifyUserViewStub viewStub;
    private ModifyUserModelStub modelStub;
    private ModifyUserController controller;
    private ModifyUserModelStub modelStubNull;
    private ModifyUserView viewStub2;
    private ModifyUserModelStub modelQueriesStub;
    
    private UserQueries query;
    private UserQueriesStub queryStub;
    
    private NavigatorStub navStub;
    
    @Before
    public void setUp(){
        query = new UserQueries();
        queryStub = new UserQueriesStub();
        
        modelStub = new ModifyUserModelStub(null, null, null, null, null, 
            null, null, ModifyUserModelStub.UserType.valueOf("P"), query);
        viewStub = new ModifyUserViewStub(navStub, modelStub);
        controller = new ModifyUserController(viewStub, modelStub);
        modelStubNull = null;
        viewStub2 = new ModifyUserViewStub(navStub, modelStubNull);
        modelQueriesStub = new ModifyUserModelStub(null, null, null, null, null, 
            null, null, ModifyUserModelStub.UserType.valueOf("P"), queryStub);
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
    
    
    @Test
    public void testFillFormWithCorrectModel(){
        assertTrue(viewStub.fillForm());
    }
    
    @Test
    public void testFillFormWithNullModel(){
        assertFalse(viewStub2.fillForm());
    }
    
    @Test
    public void testGetUserIdeal() throws SQLException, NotFoundException{
        User user = new User("", "", "AAAAAA00A00A000A", "", "", "", "", User.UserType.P);
        assertEquals(user.getCf(),
            modelQueriesStub.getQuery().getUser("AAAAAA00A00A000A").getCf());
    }
    
    @Test
    public void testGetUserWithWrongCf() throws SQLException, NotFoundException{
        assertEquals(modelQueriesStub.getQuery().getUser("X"),
                null);
    }
    
    @Test 
    public void testModifyIdeal(){
        User user = new User("", "", "AAAAAA00A00A000A", "", "", "", "", User.UserType.P);
        assertTrue(modelQueriesStub.getQuery().modify(user));
    }
    
    @Test 
    public void testModifyWithWrongUser(){
        User user = new User("", "", "X", "", "", "", "", User.UserType.P);
        assertFalse(modelQueriesStub.getQuery().modify(user));
    }
    
    
}
