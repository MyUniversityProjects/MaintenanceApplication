package root.screens.manageusers;

import queries.UserQueries;
import root.entities.User;

public class ManageUsersModel {
    private User[] users = {};
    private final UserQueries queryTool;

    public ManageUsersModel(UserQueries queryTool) {
        this.queryTool = queryTool;
    }

    public User[] getUsers() {
        return users;
    }

    public void fetch() {
        
    }
    
    /**
     * 
     * @param index 
     * @throws InvalidIndexException
     */
    public void delete(int index) {
    }
}
