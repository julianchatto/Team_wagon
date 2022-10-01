import java.util.ArrayList;

public class Rushee extends User{
    private int classYear;
    
    private Frat topBid;

    public Rushee(String name, String username, String password, int classYear, Frat topBid, String description) {
        super(username, password, description,name);
        this.classYear = classYear;
        this.topBid = topBid;
    }

    //Getters

    public int getclassYear(){
        return classYear;
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


}
