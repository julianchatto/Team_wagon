import java.util.ArrayList;

public class Rushee extends User{
    private int classYear;
    private ArrayList<String> messages;
    private Frat topBid;

    public Rushee(String name, String username, String password, int classYear, Frat topBid, String description, ArrayList<String> messages) {
        super(username, password, description,name);
        this.classYear = classYear;
        this.topBid = topBid;
        this.messages = messages;
    }

    //Getters

    public int getclassYear(){
        return classYear;
    }


    public ArrayList<String> getMessages() {
        return messages;
    }

    public Frat gettopBid(){
        return topBid; 
    }

    
    public void setClassYear(int c) {
        classYear = c;
    }

    public void settopBid(Frat tb){
        topBid = tb;
    }
    public void addMessage(String message) {
        messages.add(message);
    }

    public String toString(){
        return "Rushee: " + super.toString() + ", class year " + classYear + ", top bid choice " + topBid  + ", description " + description; 
    }


}
