import java.util.ArrayList;

public class Frat {
    private String username;
    private String password;
    private ArrayList<String> rushees;
    private ArrayList<String> topRushees;
    private String description;

    public Frat(String username, String password, ArrayList<String> rushees, ArrayList<String> topRushees, String description) {
        this.username = username;
        this.password = password; 
        this.rushees = rushees;
        this.rushees = topRushees;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getRushees() {
        return rushees;
    }

    public ArrayList<String> getTopRushees() {
        return topRushees;
    }

    public String getDescription() {
        return description;
    }

    public void setUsername(String u) {
        username = u;
    }

    public void setPassWord(String p) {
        password = p;
    }

    public void setRushees(ArrayList<String> r) {
        rushees = r;
    }

    public void setTopRushees(ArrayList<String> r) {
        topRushees = r;
    }

    public void setDescription(String d) {
        description = d;
    }
}
