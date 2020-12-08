package root.screens.manageusers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import queries.UserQueries;
import root.entities.User;
import root.exceptions.InvalidIndexException;
import root.exceptions.QueryFailedException;

public class ManageUsersModel {
    private final List<User> users = new LinkedList<>();
    private final UserQueries queryTool;

    public ManageUsersModel(UserQueries queryTool) {
        this.queryTool = queryTool;
    }

    public User[] getUsers() {
        return users.toArray(new User[users.size()]);
    }

    public void fetch() {
        users.clear();
        users.addAll(Arrays.asList(queryTool.fetchAll()));
    }
    
    /**
     * 
     * @param index 
     * @throws QueryFailedException when the database query fails
     * @throws InvalidIndexException when index is not valid
     */
    public void delete(int index) {
        if (index < 0 || index >= users.size()) 
            throw new InvalidIndexException();
        
        if (!queryTool.delete(users.get(index).getCf()))
            throw new QueryFailedException();
        
        users.remove(index);
    }
}
