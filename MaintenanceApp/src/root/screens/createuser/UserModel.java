
package root.screens.createuser;


import queries.UserQueries;
import root.entities.User;

public class UserModel {
    private String error;
    private final UserQueries createUserQueries;

    /**
     * Creates new UserModel  
     * @param query
     */
    public UserModel(UserQueries query) {
        this.createUserQueries = query;
    }
    
    /**
     * insert a User in the database
     * 
     * @param user
     * @return 
     */
    public boolean create(User user){
        return createUserQueries.insertIntoAppUser(user);
    }
    
    /**
     * get the error given by the database
     * 
     * @return a string describing the error given by the database
     */
    public String getDatabaseError(){
        return createUserQueries.getCreateDatabaseError();
    }
    
    
}
