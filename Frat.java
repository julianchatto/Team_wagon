import java.util.ArrayList;
import java.util.Arrays;

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

    public String toString() {
        return "Frat " + super.toString() + "\nRushees: " + rushees + "\nTop Rushees: " + topRushees + "\nBio " + description;  
    }
}
