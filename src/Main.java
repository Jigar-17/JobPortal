import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JobPortalService service = new JobPortalService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register User\n2. Post Job\n3. View Jobs\n4. Apply to Job\n5. View Applicants\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Role (jobseeker/recruiter): ");
                String role = sc.nextLine();
                service.registerUser(name, email, role);

            } else if (choice == 2) {
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Company: ");
                String company = sc.nextLine();
                System.out.print("Location: ");
                String location = sc.nextLine();
                System.out.print("Description: ");
                String desc = sc.nextLine();
                System.out.print("Skills (comma separated): ");
                String[] skills = sc.nextLine().split(",");
                service.postJob(title, company, location, desc, skills);

            } else if (choice == 3) {
                service.viewAllJobs();

            } else if (choice == 4) {
                System.out.print("Your User ID: ");
                int userId = sc.nextInt();
                System.out.print("Job ID: ");
                int jobId = sc.nextInt();
                System.out.print("Experience in years: ");
                int exp = sc.nextInt();
                sc.nextLine();
                System.out.print("Your Skills (comma separated): ");
                String[] skills = sc.nextLine().split(",");
                service.applyToJob(userId, jobId, exp, skills);

            } else if (choice == 5) {
                System.out.print("Job ID: ");
                int jobId = sc.nextInt();
                service.showApplicants(jobId);

            } else break;
        }
    }
}