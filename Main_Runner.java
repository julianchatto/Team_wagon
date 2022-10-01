import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Main_Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<User> accounts = new ArrayList<>();

        boolean looping = true;
        while (looping) {
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            String option = scan.nextLine();
            switch(option) {
                case "1":
                    System.out.println("1. Rushee sign up");
                    System.out.println("2. Register a frat");
                    String option2 = scan.nextLine();
                    if (option2.equals("1")) {
                        accounts.add(rushSignUp(scan));
                    } else {
                        accounts.add(fratSignUp(scan));
                    }
                    break;
                case "2":
                    login(scan);
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        }

    }

    public static Rushee rushSignUp(Scanner scan) {
        System.out.println("Enter your email");
        String email = scan.nextLine();
        System.out.println("Enter a password");
        String password = scan.nextLine();
        System.out.println("Enter a class year (1 for freshman, 2 for sophomore, etc..");
        int classYear = Integer.parseInt(scan.nextLine());
        System.out.println("Enter your name"); 
        String name = scan.nextLine();
        Frat topbid = null;
        System.out.println("Enter a short bio");
        String bio = scan.nextLine();
        ArrayList<String> friends = null;
        return new Rushee(name, email, password, classYear, topbid, bio);
    }

    public static Frat fratSignUp(Scanner scan) {
        System.out.println("Enter your frat name");
        String fratName = scan.nextLine();
        System.out.println("Enter your email");
        String email = scan.nextLine();
        System.out.println("Enter a password");
        String password = scan.nextLine();
        boolean rushing = true;
        ArrayList<String> rushees = new ArrayList<>();
        ArrayList<String> topRushees = new ArrayList<>();
        while (rushing) {
            System.out.println("Do you want to add more rushees? (y/n)");
            String option = scan.nextLine();
            if (option.equals("n")) {
                break;
            }
            System.out.println("Enter a rushee email");
            rushees.add(scan.nextLine());
        }

        while(rushing) {
            System.out.println("Do you want to add more top rushees? (y/n)");
            String option = scan.nextLine();
            if (option.equals("n")) {
                break;
            }
            System.out.println("Enter a top rushee email");
            topRushees.add(scan.nextLine());
        }

        System.out.println("Enter a short bio");
        String bio = scan.nextLine();
        
        return new Frat(fratName, email, password, rushees, topRushees, bio);
    }
    public static void login(Scanner scan) {
        System.out.println();
    }

}
