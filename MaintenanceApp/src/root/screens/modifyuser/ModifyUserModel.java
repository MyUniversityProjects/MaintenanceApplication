package root.screens.modifyuser;

import queries.UserQueries;
import root.entities.User;

public class ModifyUserModel extends User{
    
    private final UserQueries query;

    public ModifyUserModel(String name, String surname, String cf, String email,
            String address, String username, String password,
            UserRole role, UserQueries query) {
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
     */
    public static ModifyUserModel fromDatabase(String cf, UserQueries query){
        
        try {
            User user = query.getUser(cf);
            if(user == null){
                return null;
            }
            return new ModifyUserModel(user.getName(), user.getSurname(),
                    user.getCf(), user.getEmail(), user.getAddress(),
                    user.getUsername(), user.getPassword(), 
                    user.getRole(), query);   
        } catch(Exception e){
            return null;
        } 
        
    }
    
    /**
     *Execute the query to modify the user and return if successful
     * 
     * @return if the user has been successfully modified
     */
    public boolean modify(){
        return query.modify(this);
    }

}
