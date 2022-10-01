import java.util.ArrayList;

public class Frat extends User {
    private ArrayList<String> rushees;
    private ArrayList<String> topRushees;

    public Frat(String fratName, String username, String password, ArrayList<String> rushees, ArrayList<String> topRushees, String description) {
        super(username, password, description, fratName);
        this.rushees = rushees;
        this.rushees = topRushees;
    }

    public ArrayList<String> getRushees() {
        return rushees;
    }

    public ArrayList<String> getTopRushees() {
        return topRushees;
    }

    public void setRushees(ArrayList<String> r) {
        rushees = r;
    }

    public void setTopRushees(ArrayList<String> r) {
        topRushees = r;
    }

}
