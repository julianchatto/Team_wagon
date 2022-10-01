import java.util.ArrayList;

public class Rushee {
    private String username;
    private String password;
    private int classYear;
    private String name;
    private Frat topBid;
    private String description;
    private ArrayList<String> friends; 

    public Rushee(String username, String password, int classYear, String name, Frat topBid, String description, ArrayList<String> friends) {
        this.username = username;
        this.password = password;
        this.classYear = classYear;
        this.name = name;
        this.topBid = topBid;
        this.description = description;
        this.friends = friends;
    }

    //Getters
    public String getUsername(){
        return username;
    }

    public String getpassword(){
        return password;
    }

    public int getclassYear(){
        return classYear;
    }

    public String getName(){
        return name;
    }

    public Frat gettopBid(){
        return topBid; 
    }

    public String getdescription(){
        return description;
    }

    public ArrayList<String> getfriends(){
        return friends;
    }
    
    //Setters
    public void setUsername(String u){
        username = u;
    }

    public void setPassword(String p){
        password = p; 
    }
    public void setClassYear(int c) {
        classYear = c;
    }
    public void setName(String n) {
        name =n;
    }

}
