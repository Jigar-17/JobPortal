import java.io.FileWriter;
import java.util.*;

public class JobPortalService {
    private final Map<Integer, User> users = new HashMap<>();
    private final Map<Integer, Job> jobs = new HashMap<>();
    private final Map<Integer, List<Application>> jobApplications = new HashMap<>();

    public void registerUser(String name, String email, String role) {
        User user = new User(name, email, role);
        users.put(user.getId(), user);
        System.out.println("Registered: " + user.getId() + " - " + user.getName());
    }

    public void postJob(String title, String company, String location, String desc, String[] skills) {
        Job job = new Job(title, company, location, desc, skills);
        jobs.put(job.getId(), job);
        System.out.println("Job Posted: " + job);
    }

    public void viewAllJobs() {
        for (Job job : jobs.values()) {
            System.out.println(job);
        }
    }

    public void applyToJob(int userId, int jobId, int experience, String[] skills) {
        if (!jobs.containsKey(jobId)) {
            System.out.println("Job not found.");
            return;
        }
        Application app = new Application(userId, jobId, experience, skills);
        jobApplications.computeIfAbsent(jobId, k -> new ArrayList<>()).add(app);
        System.out.println("Application submitted to Job ID: " + jobId);
        try (FileWriter fw = new FileWriter("application_logs.txt", true)) {
            fw.write("User " + userId + " applied to job " + jobId + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showApplicants(int jobId) {
        if (!jobApplications.containsKey(jobId)) {
            System.out.println("No applications yet.");
            return;
        }
        List<Application> apps = jobApplications.get(jobId);
        PriorityQueue<Application> pq = new PriorityQueue<>((a, b) -> b.getExperienceYears() - a.getExperienceYears());
        pq.addAll(apps);

        System.out.println("Applicants for Job ID " + jobId + ":");
        while (!pq.isEmpty()) {
            Application app = pq.poll();
            System.out.println("UserID: " + app.getUserId() + ", Experience: " + app.getExperienceYears());
        }
    }
}