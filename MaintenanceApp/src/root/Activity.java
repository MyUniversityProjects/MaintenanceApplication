package root;

public class Activity {
    private int id;
    private String branch_office;
    private String area;
    private String typology;
    private String description;
    private int estimated_time;
    private boolean interruptible;
    private int week;
    private String workspace_notes;
    private String type_activity;
    String getBranch_office;

    public Activity(int id, String branch_office, String area, String typology,
            String description, int estimated_time, boolean interruptible,
            int week, String workspace_notes, String type_activity) {
        this.id = id;
        this.branch_office = branch_office;
        this.area = area;
        this.typology = typology;
        this.description = description;
        this.estimated_time = estimated_time;
        this.interruptible = interruptible;
        this.week = week;
        this.workspace_notes = workspace_notes;
        this.type_activity = type_activity;
    }
    
    public Activity(int id, String branch_office, String area, String typology,
            String description, int estimated_time, boolean interruptible,
            int week, String type_activity) {
        this.id = id;
        this.branch_office = branch_office;
        this.area = area;
        this.typology = typology;
        this.description = description;
        this.estimated_time = estimated_time;
        this.interruptible = interruptible;
        this.week = week;
        this.type_activity = type_activity;
        this.workspace_notes = "";
    }

    public int getId() {
        return id;
    }

    public String getBranch_office() {
        return branch_office;
    }

    public String getArea() {
        return area;
    }

    public String getTypology() {
        return typology;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimated_time() {
        return estimated_time;
    }

    public boolean isInterruptible() {
        return interruptible;
    }

    public int getWeek() {
        return week;
    }

    public String getWorkspace_notes() {
        return workspace_notes;
    }

    public String getType_activity() {
        return type_activity;
    }

    @Override
    public String toString() {
        return "id=" + id + ", branch_office=" + branch_office + ", area=" + area + ", typology=" + typology + ", description=" + description + ", estimated_time=" + estimated_time + ", interruptible=" + interruptible + ", week=" + week + ", workspace_notes=" + workspace_notes + ", type_activity=" + type_activity;
    }
    
}
