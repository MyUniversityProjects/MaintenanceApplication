
package root.screens.modifyuser;

import java.sql.SQLException;
import root.Navigator;
import root.exceptions.NotFoundException;
import root.screenbuilders.ModifyUserBuilder;

public class ModifyUserMain {
    
    public static void main(String[] args) throws SQLException, NotFoundException {
        javax.swing.JFrame app = new javax.swing.JFrame();
        UserQueries query = new UserQueries();
        
        ModifyUserModel model = ModifyUserModel.fromDatabase("X", query);
        ModifyUserView view = new ModifyUserView(new Navigator("main", new ModifyUserBuilder("X", query)), model);
        ModifyUserController controller = new ModifyUserController(view, model);
        
        app.add(view);
        app.pack();
        app.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        
        
    }
    
}
