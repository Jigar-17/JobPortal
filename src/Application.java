public class Application {
    private int userId;
    private int jobId;
    private int experienceYears;
    private String[] applicantSkills;

    public Application(int userId, int jobId, int experience, String[] skills) {
        this.userId = userId;
        this.jobId = jobId;
        this.experienceYears = experience;
        this.applicantSkills = skills;
    }

    public int getUserId() { return userId; }
    public int getJobId() { return jobId; }
    public int getExperienceYears() { return experienceYears; }
    public String[] getApplicantSkills() { return applicantSkills; }
}