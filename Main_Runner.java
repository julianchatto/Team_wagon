import java.util.ArrayList;
import java.util.Scanner;

public class Main_Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<User> accounts = new ArrayList<>();
        User users = null;
        boolean looping = true;
        while (looping) { // log in
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
                        users = accounts.get(accounts.size()-1);
                    } else {
                        accounts.add(fratSignUp(scan));
                        users = accounts.get(accounts.size()-1);
                    }
                    looping = false;
                    break;
                case "2":
                    users = login(scan, accounts);
                    if (users == null) {
                        System.out.println("Account doesn't exist");
                    } else {
                        looping = false;
                    }
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        }

        if (users instanceof Rushee) {
            rushing();
        } else {
            frating(users, scan, accounts);
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
        ArrayList<String> messages = null;
        return new Rushee(name, email, password, classYear, topbid, bio, messages);
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
    public static User login(Scanner scan, ArrayList<User> list) {
        System.out.println("Enter your username");
        String user = scan.nextLine();

        int position = findUser(list, user);
        if (position != 1) {
            return list.get(position);
        }
        return null;

    }
    public static int findUser(ArrayList<User> list, String username) throws UsernameNotFoundException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername() == username) {
                return i;
            }
        }
        throw new UsernameNotFoundException();
    }

    public static void rushing() {

    }

    public static void frating(User user, Scanner scan, ArrayList<User> list) {
        Frat frats = (Frat) user;
        System.out.println("Choose an option");
        System.out.println("1. Manage Rushees");
        System.out.println("2. Message Rushees");
        System.out.println("3. View Profile");
        String choice = scan.nextLine();
        if (choice.equals("1")) {
            System.out.println("1. Add rushees");
            System.out.println("2. Add rushees to top Rushees");
            System.out.println("3. Remove rushees");
            System.out.println("4. Remove rushees from top rushees");
            choice = scan.nextLine();

            if (choice.equals("1")) {
                rushSignUp(scan);
                System.out.println("Enter rushee email");
                choice = scan.nextLine();
                frats.getRushees().add(choice);
                

            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {

            } else {

            }

        } else if(choice.equals("3")) {
            System.out.println("Choose an option");
            System.out.println("1. Message all rushees");
            System.out.println("2. Message top rushees");
            choice = scan.nextLine();
            message(choice, user, list, scan);

        } else {
            user.toString();
        }
        

    }

    public static void add(String choice, User user, ArrayList<User> list, Scanner scan) {
        
    }

    public static void message(String choice, User user, ArrayList<User> list, Scanner scan) {
        System.out.println("Enter your message");
        String message = scan.nextLine();
        Frat frats = (Frat) user;
        if (choice.equals("1")) {
            for (String f : frats.getRushees()) {
                int position = findUser(list, f);
                list.get(position).addMessage(message);
            }

        } else {
            for (String f : frats.getRushees()) {
                int position = findUser(list, f);
                list.get(position).addMessage(message);
            }
        }
        
    }

}
