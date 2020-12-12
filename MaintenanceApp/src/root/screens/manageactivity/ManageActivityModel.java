
package root.screens.manageactivity;

import java.util.List;
import queries.ActivityQueries;
import root.entities.Activity;

/**
 *
 * @author giand
 */
public class ManageActivityModel {
    
    private final ActivityQueries query;

    public ManageActivityModel(ActivityQueries query) {
        this.query = query;
    }
    
    /**
     * Take from the database the activities
     * 
     * @return a list of Activities
     */
    
    public List<Activity> getActivities(){
        
       List<Activity> activities = query.fetchAll();
        
        return activities;
    }
    
    /**
     * 
     * Delete from the database tha activity that have 
     * id equal to the passed param
     * 
     * @param id
     * @return if the delete was successful
     */
    
    public boolean delete(int id){
        return query.delete(id);
    }
        
}
