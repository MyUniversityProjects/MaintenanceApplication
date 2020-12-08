
/**
 *
 * @author giand
 */
import root.screens.createuser.UserQueries;

public class UserModelTest {
    
    
    private class UserQueriesStub extends UserQueries {

        public UserQueriesStub() {
            super();
        }
        

        @Override
        public boolean openConnection() {
            return true;
        }
        
        @Override
        public boolean closeConnection() {
            return true; 
        }
        

        public boolean insertIntoAppUser(String user) {
            return true;
        }

    }

   

}
