package stubs;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import queries.ActivityQueries;
import root.entities.Activity;
import root.entities.Activity.ActivityType;

public class ActivityQueriesStub extends ActivityQueries {
    public static final String[] MATERIALS = {"A", "B", "C"};
    public static final String[] COMPETENCES = {"1", "2"};
    
    private int forwardEwoCounter = 0;
    private int forwardScheduledCounter = 0;
    private int fetchCounter = 0;
    private int fetchCompleteCounter = 0;
    private int createCounter = 0;
    private int fetchAllCounter = 0;
    private int deleteCounter = 0;
    private int typologiesCounter = 0;
    private int updateMaterialsToActivityCounter = 0;
    private int assignMaterialsToActivityCounter = 0;
    private int modifyCounter = 0;

    public int getForwardEwoCounter() {
        return forwardEwoCounter;
    }

    public int getForwardScheduledCounter() {
        return forwardScheduledCounter;
    }

    public int getFetchCounter() {
        return fetchCounter;
    }
    
    public int getFetchCompleteCounter() {
        return fetchCompleteCounter;
    }

    @Override
    public void forwardEwo(int id, String desc, int time, String[] materials, String[] competences) {
        forwardEwoCounter++;
    }

    @Override
    public void forwardScheduled(int id, String notes) {
        forwardScheduledCounter++;
    }

    @Override
    public Activity fetch(int id){
        fetchCounter++;
        return new Activity(1, "area", "office", "typology", "description", 10, true, 1, "notes", ActivityType.PLANNED);
    }

    @Override
    public Activity fetchComplete(int id) {
        fetchCompleteCounter++;
        return new Activity(1, "area", "office", "typology", "description", 10, true, 1, "notes", ActivityType.PLANNED, MATERIALS, COMPETENCES);
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

    @Override
    public boolean updateMaterialsToActivity(String[] materials, int id) {
        updateMaterialsToActivityCounter++;
        return true;
    }

    @Override
    public boolean assignMaterialsToActivity(String[] materials, int id) {
        assignMaterialsToActivityCounter++;
        return true;
    }

    @Override
    public boolean modify(Map<String, String> inputMap) {
        modifyCounter++;
        return true;
    }
    
    
    
}
