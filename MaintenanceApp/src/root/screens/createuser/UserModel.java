/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.createuser;

/**
 *
 * @author ficca
 */
public class UserModel {
    private String error;
    private int errorCode;  
    private final UserQueries createUserQueries;

    public UserModel() {
        this.createUserQueries = new UserQueries();
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
    
    
    public String getDatabaseError(){
        return createUserQueries.getDatabaseError();
    }
    
    
}
