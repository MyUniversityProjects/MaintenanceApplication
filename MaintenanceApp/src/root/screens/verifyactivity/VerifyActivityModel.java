package root.screens.verifyactivity;

import javax.swing.DefaultListModel;
import queries.ActivityQueries;
import root.entities.Activity;
import root.exceptions.NotFoundException;
import root.exceptions.QueryFailedException;


public class VerifyActivityModel extends Activity {
    private static final String PREFIX = "\t• ";
    private final ActivityQueries queryTool;
    private final DefaultListModel<String> materialsModel = new DefaultListModel<>();
    private final ListFillModel skillFillModel;
    
    public VerifyActivityModel(Activity activity, ActivityQueries queryTool) {
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
        this.queryTool = queryTool;
        
        skillFillModel = new ListFillModel(
                new String[] {"B1", "C1"},
                new String[] {"A1", "B1", "C1", "D1", "E1", "F5"}
        );
    }
    
    public ListFillModel getSkillFillModel() {
        return skillFillModel;
    }

    public DefaultListModel<String> getMaterialsModel() {
        return materialsModel;
    }
    
    /**
     * Add selcted skill to the skill list model; Nothing happens if there
     * are no skill selected.
     */
    public void addSkillFromComboBox() {
        skillFillModel.addSelected();
    }
    
    /**
     * Add material name to the UI list model for the materials
     * @param name the name of the material; must not be null
     */
    public void addMaterial(String name) {
        materialsModel.addElement(PREFIX + name);
    }
    
    /**
     * Remove material name to the UI list model for the materials
     * @param name the name of the material; must not be null
     */
    public void removeMaterial(String name) {
        materialsModel.removeElement(PREFIX + name);
    }
    
    /**
     * Create and return an instance of VerifyActivityModel by fetching the
     * data of the activity, from the database
     * @param id activity identifier
     * @param queryTool used to make queries to the database
     * @return and instance of VerifyActivityModel
     * @throws NotFoundException if the activity is not found
     * @throws QueryFailedException if app is unable to query the database
     */
    public static VerifyActivityModel fromDatabase(int id, ActivityQueries queryTool) throws NotFoundException {
        Activity activity = queryTool.fetch(id);
        return new VerifyActivityModel(activity, queryTool);
    }
    
    /**
     * Verify and update the activity.
     * @throws NotFoundException 
     * @throws QueryFailedException if app is unable to query the database
     */
    public void forward() throws NotFoundException {
        if (getType() == ActivityType.PLANNED) {
            queryTool.forwardScheduled(getId(), getNotes());
        } else {
            queryTool.forwardEwo(getId(), getDescription(), getTime());
        }
    }
}
