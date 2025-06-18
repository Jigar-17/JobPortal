public class User {
    private static int idCounter = 1;
    private final int id;
    private String name;
    private String email;
    private String role; // "jobseeker" or "recruiter"

    public User(String name, String email, String role) {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getRole() {
        return role;
    }
}