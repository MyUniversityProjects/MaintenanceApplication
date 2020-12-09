package root.screens.manageusers;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import queries.UserQueries;
import root.entities.User;
import root.exceptions.InvalidIndexException;
import root.exceptions.QueryFailedException;

public class ManageUsersModel {
    public static final String[] columnNames = {"Fiscal Code", "Username", "Name", "Surname", "Role", "delete", "edit"};
    private final List<User> users = new LinkedList<>();
    private final DefaultTableModel tableModel;
    private final UserQueries queryTool;

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
     * @param queryTool
     * @return 
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
     * 
     * @param index 
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
