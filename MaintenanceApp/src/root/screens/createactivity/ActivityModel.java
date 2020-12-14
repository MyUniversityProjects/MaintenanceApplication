package root.screens.createactivity;


import java.sql.SQLException;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import root.entities.Activity;
import queries.*;
import ui.ListFillModel;

public class ActivityModel extends Activity{
    private final ActivityQueries query;
    private final MaterialQueries materialQuery;
    private ListFillModel materialFillModel;
    private final ComboBoxModel<String> typologyInputModel;
    
    public ActivityModel(ActivityQueries query,MaterialQueries materialQuery) throws SQLException {
        super();
        this.query = query;
        this.materialQuery = materialQuery;
        this.materialFillModel = new ListFillModel(new String[] {},materialQuery.fetchAll());
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
    
    public ListFillModel getMaterialFillModel() {
        return materialFillModel;
    }
    
    /**
     * Add selcted material to the material list model; Nothing happens if there
     * are no material selected or the material is already on the list.
     */
    public void addSelectedMaterial() {
        materialFillModel.addSelected();
    }
    
    /**
     * Remove selcted material from the material list model; Nothing happens if 
     * there are no material selected or the material is not on the list.
     */
    public void removeSelectedMaterial() {
        materialFillModel.removeSelected();
    }
    
    public boolean assignMaterialsToActivity(int id){
        return query.assignMaterialsToActivity(materialFillModel.getElements(),id);
    }

    public String getTypology(){
        return (String) typologyInputModel.getSelectedItem();
    }
    
    public ComboBoxModel<String> getTypologyInputModel(){
        return typologyInputModel;
    }
}
