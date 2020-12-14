package root.screens.createactivity;


import java.sql.SQLException;
import root.entities.Activity;
import queries.ActivityQueries;
import ui.ListFillModel;

public class ActivityModel extends Activity{
    private final ActivityQueries query;
    private ListFillModel materialFillModel;
    
    public ActivityModel(ActivityQueries query) throws SQLException {
        super();
        this.query = query;
        this.materialFillModel = new ListFillModel(new String[] {},query.getMaterials());
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

}
