package root.screens.createactivity;


import root.entities.Activity;
import queries.ActivityQueries;

public class ActivityModel extends Activity{
    private final ActivityQueries query;

    public ActivityModel(ActivityQueries query) {
        super();
        this.query = query;
    }

    /**
     * insert the activity into the database
     * 
     * @return if the entry was successful
     */
    public boolean create(){
       return query.create(this);
    }
}
