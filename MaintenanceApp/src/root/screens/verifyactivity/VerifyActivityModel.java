package root.screens.verifyactivity;

import ui.ListFillModel;
import queries.ActivityQueries;
import queries.CompetenceQueries;
import queries.MaterialQueries;
import root.entities.Activity;
import root.exceptions.NotFoundException;
import root.exceptions.QueryFailedException;


public class VerifyActivityModel extends Activity {
    private final ActivityQueries queryTool;
    private final ListFillModel skillFillModel;
    private final ListFillModel materialFillModel;
    
    public VerifyActivityModel(Activity activity, ActivityQueries queryTool, String[] allCompetences, String[] allMaterials) {
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
                activity.getType(),
                activity.getMaterials(),
                activity.getCompetences()
        );
        this.queryTool = queryTool;
        
        skillFillModel = new ListFillModel(
                activity.getCompetences(),
                allCompetences
        );
        materialFillModel = new ListFillModel(
                activity.getMaterials(),
                allMaterials
        );
    }
    
    public VerifyActivityModel(Activity activity, ActivityQueries queryTool) {
        this(activity, queryTool, new String[] {}, new String[] {});
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
     * @param matQuery used (eventually) to get all materials
     * @param compQuery used (eventually) to get all competences
     * @return and instance of VerifyActivityModel
     * @throws NotFoundException if the activity is not found
     * @throws QueryFailedException if app is unable to query the database
     */
    public static VerifyActivityModel fromDatabase(int id, ActivityQueries queryTool, MaterialQueries matQuery, CompetenceQueries compQuery) throws NotFoundException {
        Activity activity = queryTool.fetchComplete(id);
        
        if (activity.getType() == ActivityType.PLANNED){
            return new VerifyActivityModel(activity, queryTool, new String[] {}, new String[] {});
        } else {
            String[] materials = matQuery.fetchAll();
            String[] competences = compQuery.fetchAll();
            return new VerifyActivityModel(activity, queryTool, competences, materials);
        }
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
            queryTool.forwardEwo(getId(), getDescription(), getTime(), materialFillModel.getElements(), skillFillModel.getElements());
        }
    }
}
