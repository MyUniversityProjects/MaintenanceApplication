package root.screens.manageusers;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import queries.UserQueries;
import root.entities.User;
import root.exceptions.InvalidIndexException;
import root.exceptions.QueryFailedException;

/**
 * Contains and handle the ManageUsersView data.
 */
public class ManageUsersModel {
    public static final String[] columnNames = {"Fiscal Code", "Username", "Name", "Surname", "Role", "delete", "edit"};
    private final List<User> users = new LinkedList<>();
    private final DefaultTableModel tableModel;
    private final UserQueries queryTool;
    
    /**
     * Create an instance of ManageUsersModel
     * @param queryTool used to execute queries to the database
     * @param users the planners and maintainers to display in ManageUsersView
     */
    public ManageUsersModel(UserQueries queryTool, User[] users) {
        String[][] data = new String[users.length][columnNames.length];
        for (int i=0; i < users.length; i++) {
            User user = users[i];
            data[i][0] = user.getCf();
            data[i][1] = user.getUsername();
            data[i][2] = user.getName();
            data[i][3] = user.getSurname();
            data[i][4] = user.getRole() == User.UserRole.PLANNER ? "Planner" : "Maintainer";
            data[i][5] = "delete";
            data[i][6] = "edit";
            this.users.add(user);
        }
        this.tableModel = new DefaultTableModel(data, columnNames);
        this.queryTool = queryTool;
    }
    
    /**
     * Fetch users from the database than create and return an instance of
     * ManageUsersModel with the fetched users
     * @param queryTool used to execute queries to the database
     * @return an instance of ManageUsersModel with the users fetched from
     *         the database
     * @throws QueryFailedException when the database query fails
     */
    public static ManageUsersModel fromDatabase(UserQueries queryTool) {
        User[] users = queryTool.fetchPlannersMaintainers();
        return new ManageUsersModel(queryTool, users);
    }
    
    public User[] getUsers() {
        return users.toArray(new User[users.size()]);
    }
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    /**
     * Delete an user at certain index from the Database and table model
     * @param index the index of the user in the table
     * @throws QueryFailedException when the database query fails
     * @throws InvalidIndexException when index is not valid
     */
    public void delete(int index) {
        if (index < 0 || index >= users.size()) 
            throw new InvalidIndexException();
        
        if (!queryTool.delete(users.get(index).getCf()))
            throw new QueryFailedException("Something went wrong!");
        
        users.remove(index);
        tableModel.removeRow(index);
    }
}
