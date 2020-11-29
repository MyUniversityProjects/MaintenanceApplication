package root.entities;

public class Activity {
    private int id;
    private String area;
    private String branchOffice;
    private String typology;
    private String description;
    private int time;
    private boolean interruptible;
    private int week;
    private String notes;
    private ActivityType type;
    
    
    public enum ActivityType {PLANNED, UNPLANNED, EXTRA};

    public Activity(int id, String area, String branchOffice, String typology, String description, int time, boolean interruptible, int week, String notes, ActivityType type) {
        this.id = id;
        this.area = area;
        this.branchOffice = branchOffice;
        this.typology = typology;
        this.description = description;
        this.time = time;
        this.interruptible = interruptible;
        this.week = week;
        this.notes = notes;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(String branchOffice) {
        this.branchOffice = branchOffice;
    }

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isInterruptible() {
        return interruptible;
    }

    public void setInterruptible(boolean interruptible) {
        this.interruptible = interruptible;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }
    
    public static ActivityType convertRawType(String type) {
        switch (type) {
            case "P": return ActivityType.PLANNED;
            case "EWO": return ActivityType.UNPLANNED;
            case "EXTRA": return ActivityType.EXTRA;
            default: return null;
        }
    }
}
