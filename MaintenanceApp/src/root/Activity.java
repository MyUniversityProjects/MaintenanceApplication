package root;

public class Activity {
    private int id;
    private String branchOffice;
    private String area;
    private String typology;
    private String description;
    private int estimatedTime;
    private boolean interruptible;
    private int week;
    private String workspaceNotes;
    private String typeActivity;

    public Activity(int id, String branch_office, String area, String typology,
            String description, int estimated_time, boolean interruptible,
            int week, String workspace_notes, String type_activity) {
        this.id = id;
        this.branchOffice = branch_office;
        this.area = area;
        this.typology = typology;
        this.description = description;
        this.estimatedTime = estimated_time;
        this.interruptible = interruptible;
        this.week = week;
        this.workspaceNotes = workspace_notes;
        this.typeActivity = type_activity;
    }
    
    public Activity(int id, String branch_office, String area, String typology,
            String description, int estimated_time, boolean interruptible,
            int week, String type_activity) {
        this.id = id;
        this.branchOffice = branch_office;
        this.area = area;
        this.typology = typology;
        this.description = description;
        this.estimatedTime = estimated_time;
        this.interruptible = interruptible;
        this.week = week;
        this.typeActivity = type_activity;
        this.workspaceNotes = "";
    }

    public int getId() {
        return id;
    }

    public String getBranchOffice() {
        return branchOffice;
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

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public boolean isInterruptible() {
        return interruptible;
    }

    public int getWeek() {
        return week;
    }

    public String getWorkspaceNotes() {
        return workspaceNotes;
    }

    public String getTypeActivity() {
        return typeActivity;
    }

    @Override
    public String toString() {
        return "id=" + id + ", branch_office=" + branchOffice + ", area=" + area + ", typology=" + typology + ", description=" + description + ", estimated_time=" + estimatedTime + ", interruptible=" + interruptible + ", week=" + week + ", workspace_notes=" + workspaceNotes + ", type_activity=" + typeActivity;
    }
    
}
