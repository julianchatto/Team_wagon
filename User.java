public class User {
    private String username;
    private String password;
    protected String description;
    private String name;

    public User(String username, String password, String description, String name) {
        this.username =username;
        this.password = password;
        this.description = description;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }
    public String getName(){
        return name;
    }
    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public void setUsername(String u) {
        username = u;
    }

    public void setPassword(String p) {
        password = p;
    }

    public void setDescription(String d) {
        description = d;
    }
    public void setName(String n) {
        name = n;
    }
    public String toString() {
        return "Name " + name +  ", Email " + username;
    }

    public void addMessage(String message) {
        
    }
}
