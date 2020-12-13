package root.screens.modifyselectedactivity;

import java.util.Map;
import queries.ActivityQueries;
import root.entities.Activity;
import root.exceptions.NotFoundException;


public class ModifySelectedActivityModel extends Activity {
    ActivityQueries modifyActivityQueries;
    public ModifySelectedActivityModel(Activity activity,ActivityQueries modifyActivityQueries){
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
    }
    
    /**
     * Create and return an instance of ModifySelectedActivityModel by fetching the
     * data of the activity, from the database
     * @param id activity identifier
     * @param query
     * @return and instance of ModifySelectedActivityModel
     * @throws root.exceptions.NotFoundException 
     */
    public static ModifySelectedActivityModel fromDatabase(int id, ActivityQueries query) throws NotFoundException {
        Activity activity = query.fetch(id);
        return new ModifySelectedActivityModel(activity, query);
    }
    /**
     * Modify the activity. 
     * @param inputMap
     * @return true if the modify was successful, false if not successful
     */
    public boolean modify(Map<String, String> inputMap){
        return modifyActivityQueries.modify(inputMap);
    }

}
    

