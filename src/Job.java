public class Job {
    private static int jobIdCounter = 100;
    private final int id;
    private String title;
    private String company;
    private String location;
    private String description;
    private String[] skillsRequired;

    public Job(String title, String company, String location, String description, String[] skills) {
        this.id = jobIdCounter++;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.skillsRequired = skills;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCompany() { return company; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public String[] getSkillsRequired() { return skillsRequired; }

    @Override
    public String toString() {
        return id + ": " + title + " at " + company + " in " + location;
    }
}