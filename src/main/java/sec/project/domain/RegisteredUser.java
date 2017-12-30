package sec.project.domain;

public class RegisteredUser {
    
    private String name;
    private String password;
    
    public RegisteredUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
}
