package stubs;

import java.util.LinkedList;
import java.util.List;
import queries.ActivityQueries;
import root.entities.Activity;

public class ActivityQueriesStub extends ActivityQueries {
    private int forwardEwoCounter = 0;
    private int forwardScheduledCounter = 0;
    private int fetchCounter = 0;
    private int createCounter = 0;
    private int fetchAllCounter = 0;
    private int deleteCounter = 0;
    private int typologiesCounter = 0;

    public int getForwardEwoCounter() {
        return forwardEwoCounter;
    }

    public int getForwardScheduledCounter() {
        return forwardScheduledCounter;
    }

    public int getFetchCounter() {
        return fetchCounter;
    }

    @Override
    public void forwardEwo(int id, String desc, int time) {
        forwardEwoCounter++;
    }

    @Override
    public void forwardScheduled(int id, String notes) {
        forwardScheduledCounter++;
    }

    @Override
    public Activity fetch(int id){
        fetchCounter++;
        return new Activity(1, "area", "office", "typology", "description", 10, true, 1, "notes", Activity.ActivityType.PLANNED);
    }
    
    @Override
    public boolean create(Activity activity){
        createCounter++;
        return true;
    }
    
    @Override
    public List<Activity> fetchAll(){
        fetchAllCounter++;
        return new LinkedList<>();
    }
    
    @Override
    public boolean delete(int id){
        deleteCounter++;
        return true;
    }
    
    @Override
    public List<String> getTypologies(){
        typologiesCounter++;
        return new LinkedList<>();
    }
}
