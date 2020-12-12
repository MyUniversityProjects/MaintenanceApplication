
package root.screens.createuser;

import java.sql.SQLException;
import queries.UserQueries;
import root.Navigator;
import root.exceptions.NotFoundException;
import root.screenbuilders.CreateUserBuilder;

public class UserMain {
    
    public static void main(String[] args) throws SQLException, NotFoundException {
        javax.swing.JFrame app = new javax.swing.JFrame();
        
        UserModel model = new UserModel(new UserQueries());
        UserView view = new UserView(new Navigator("main", new CreateUserBuilder()));
        UserController controller = new UserController(model, view);
        
        app.add(view);
        app.pack();
        app.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        
        
    }
    
}
