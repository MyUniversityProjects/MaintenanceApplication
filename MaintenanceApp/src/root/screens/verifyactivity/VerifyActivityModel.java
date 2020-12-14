package root.screens.verifyactivity;

import ui.ListFillModel;
import queries.ActivityQueries;
import root.entities.Activity;
import root.exceptions.NotFoundException;
import root.exceptions.QueryFailedException;


public class VerifyActivityModel extends Activity {
    private final ActivityQueries queryTool;
    private final ListFillModel skillFillModel;
    private final ListFillModel materialFillModel;
    
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
        materialFillModel = new ListFillModel(
                new String[] {},
                new String[] {"Material-1", "Material-2", "Material-3", "Material-4", "Material-5", "Material-6"}
        );
    }
    
    public ListFillModel getSkillFillModel() {
        return skillFillModel;
    }
    
    public ListFillModel getMaterialFillModel() {
        return materialFillModel;
    }
    
    /**
     * Add selcted skill to the skill list model; Nothing happens if there
     * are no skill selected or the skill is already on the list.
     */
    public void addSelectedSkill() {
        skillFillModel.addSelected();
    }
    
    /**
     * Remove selcted skill from the skill list model; Nothing happens if 
     * there are no skill selected or the skill is not on the list.
     */
    public void removeSelectedSkill() {
        skillFillModel.removeSelected();
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
