package stubs;

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
}
