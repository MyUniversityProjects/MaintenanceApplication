package root.screens.verifyactivity;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import queries.ActivityQueries;
import root.entities.Activity;
import root.exceptions.NotFoundException;
import root.exceptions.QueryFailedException;


public class VerifyActivityModel extends Activity {
    private static final String PREFIX = "\t• ";
    private final ActivityQueries queryTool;
    private final DefaultListModel<String> skillsModel = new DefaultListModel<>();
    private final DefaultListModel<String> materialsModel = new DefaultListModel<>();
    private final DefaultComboBoxModel<String> remainingSkillsModel = new DefaultComboBoxModel<>();
    
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
        
        remainingSkillsModel.addElement("A1");
        remainingSkillsModel.addElement("B1");
        remainingSkillsModel.addElement("C1");
        remainingSkillsModel.addElement("D1");
        remainingSkillsModel.addElement("E1");
    }

    public DefaultListModel<String> getSkillsModel() {
        return skillsModel;
    }

    public DefaultListModel<String> getMaterialsModel() {
        return materialsModel;
    }

    public DefaultComboBoxModel<String> getRemainingSkillsModel() {
        return remainingSkillsModel;
    }
    
    /**
     * Add selcted skill to the skill list model; Nothing happens if there
     * are no skill selected.
     */
    public void addSkillFromComboBox() {
        String name = (String)remainingSkillsModel.getSelectedItem();
        if (name != null) {
            skillsModel.addElement(PREFIX + name);
            remainingSkillsModel.removeElement(name);
        }
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
    
    /**
     * Used to get an array of String of the elements in a list model
     * @param m the model used to get the array of String
     * @return an array of with the elements of the model
     */
    private static String[] convertModel(DefaultListModel<String> m) {
        int size = m.getSize();
        String[] arr = new String[size];
        
        for (int i=0; i<size; i++)
            arr[i] = m.get(i).substring(PREFIX.length());
        
        return arr;
    }
}
