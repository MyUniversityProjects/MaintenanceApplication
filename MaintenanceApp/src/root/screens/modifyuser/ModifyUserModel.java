package root.screens.modifyuser;

import java.sql.SQLException;
import root.exceptions.NotFoundException;

public class ModifyUserModel extends User{
    
    private final UserQueries query;

    public ModifyUserModel(String name, String surname, String cf, String email,
            String address, String username, String password,
            UserType role, UserQueries query) {
        super(name, surname, cf, email, address, username, password, role);
        this.query = query;
    }
    
    /**
     *Create and return an istance of ModifyUserModel fetching
     * data from database
     * 
     * @param cf User identifier
     * @param query
     * @return an istance of ModifyUserModel
     * @throws java.sql.SQLException
     * @throws root.exceptions.NotFoundException
     */
    public static ModifyUserModel fromDatabase(String cf, UserQueries query)
        throws SQLException, NotFoundException{
        
        try {
            User user = query.getUser(cf);
            if(user == null){
                return null;
            }
            return new ModifyUserModel(user.getName(), user.getSurname(),
                    user.getCf(), user.getEmail(), user.getAddress(),
                    user.getUsername(), user.getPassword(), 
                    user.getRole(), query);   
        } catch(SQLException | NotFoundException e){
            return null;
        } 
        
    }
    
    /**
     *Execute the query to modify the user and return if successful
     * 
     * @return if the user has been successfully modified
     * @throws java.sql.SQLException
     */
    public boolean modify() throws SQLException{
        return query.modify(this);
    }

}
