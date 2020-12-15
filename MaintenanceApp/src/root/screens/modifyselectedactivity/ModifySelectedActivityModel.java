package root.screens.modifyselectedactivity;

import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import queries.ActivityQueries;
import queries.MaterialQueries;
import root.entities.Activity;
import root.exceptions.NotFoundException;
import ui.ListFillModel;


public class ModifySelectedActivityModel extends Activity {
    ActivityQueries modifyActivityQueries;
    ListFillModel materialFillModel;
    private final ComboBoxModel<String> typologyInputModel;
    public ModifySelectedActivityModel(Activity activity,ActivityQueries modifyActivityQueries, String[] allMaterials){
        super(
                activity.getId(),
                activity.getArea(),
                activity.getBranchOffice(),
                activity.getTypology(),
                activity.getDescription(),
                activity.getTime(),
                activity.isInterruptible(),
                activity.getWeek(),
                activity.getNotes(),
                activity.getType()
        );
        this.modifyActivityQueries = modifyActivityQueries;
        this.materialFillModel = new ListFillModel(activity.getMaterials(), allMaterials);
        this.typologyInputModel = new DefaultComboBoxModel(
            modifyActivityQueries.getTypologies().toArray());
    }
    
    /**
     * Create and return an instance of ModifySelectedActivityModel by fetching the
     * data of the activity, from the database
     * @param id activity identifier
     * @param query
     * @param materialQuery
     * @return and instance of ModifySelectedActivityModel
     * @throws root.exceptions.NotFoundException 
     */
    public static ModifySelectedActivityModel fromDatabase(int id, ActivityQueries query,MaterialQueries materialQuery) throws NotFoundException {
        String[] materials = materialQuery.fetchAll();    
        Activity activity = query.fetchComplete(id);
        return new ModifySelectedActivityModel(activity,query,materials);
    }
    

    /**
     * Modify the activity. 
     * @param inputMap
     * @return true if the modify was successful, false if not successful
     */
    public boolean modify(Map<String, String> inputMap){
        return modifyActivityQueries.modify(inputMap);
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
    
    public boolean updateMaterialsToActivity(int id){
        return modifyActivityQueries.updateMaterialsToActivity(materialFillModel.getElements(),id);
    } 
    
    public String getTypology(){
        return (String) typologyInputModel.getSelectedItem();
    }
    
    public ComboBoxModel<String> getTypologyInputModel(){
        return typologyInputModel;
    }
}
    

