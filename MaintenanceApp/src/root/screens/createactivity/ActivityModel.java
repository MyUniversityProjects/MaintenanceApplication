package root.screens.createactivity;


import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import root.entities.Activity;
import queries.ActivityQueries;

public class ActivityModel extends Activity{
    private final ActivityQueries query;
    private final ComboBoxModel<String> typologyInputModel;

    public ActivityModel(ActivityQueries query) {
        super();
        this.query = query;
        this.typologyInputModel = new DefaultComboBoxModel(
            query.getTypologies().toArray());
    }

    /**
     * insert the activity into the database
     * 
     * @return if the entry was successful
     */
    public boolean create(){
       return query.create(this);
    }
    
    public String getTypology(){
        return (String) typologyInputModel.getSelectedItem();
    }
    
    public ComboBoxModel<String> getTypologyInputModel(){
        return typologyInputModel;
    }
}
