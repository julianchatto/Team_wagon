import java.util.ArrayList;
import java.util.Scanner;

public class Main_Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<User> accounts = new ArrayList<>();
        accounts.add(new Rushee("Julian Chat", "juc226@lehigh.edu","password",1,"Phi Delt", "I am cool",null));
        accounts.add(new Frat("Phi Delt", "ank726@lehigh.edu","pass",null, null, "We are cool"));
        accounts.add(new Rushee("Andrew Todaro","apt226@lehigh.edu","bob",1,"Theta Chi","Academic Weapon",null));
        accounts.add(new Frat("Theta Chi","ekg226@lehigh.edu","password1",null,null,"Theta Chi rules"));
        accounts.add(new Rushee("Daniel In","dai226@lehigh.edu","weightLifter",1,"D Chi","Swagger",null));
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
            rushing(scan, users);
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
        String topbid = "";
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
            boolean passwording = true;
            while(passwording) {
                System.out.println("Enter your password");
                String pass = scan.nextLine();
                if (pass.equals(list.get(position).getPassword())) {
                    passwording = false;
                    return list.get(position);
                }
            }
            

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

    public static void rushing(Scanner scan, User user) {
        System.out.println("Choose an option");
        System.out.println("1. View invites");
        System.out.println("2. View profile");
        String option = scan.nextLine();

        if (option.equals("1")) {
            Rushee rush = (Rushee) user;
            rush.getMessages();
        } else {
            user.toString();
        }

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
                System.out.println("Enter rushee email");
                choice = scan.nextLine();
                int position = findUser(list, choice);
                if (position != 1) {
                    frats.getRushees().add(choice);
                } else {
                    System.out.println("Rushee account not found");
                }
                

            } else if (choice.equals("2")) {
                System.out.println("Enter top rushee email");
                choice = scan.nextLine();
                int position = findUser(list, choice);
                if (position != 1) {
                    frats.getTopRushees().add(choice);
                } else {
                    System.out.println("Top rushee account not found");
                }

            } else if (choice.equals("3")) {
                System.out.println("Enter top rushee email");
                choice = scan.nextLine();
                removeRushees(choice, user, scan);
            } else {
                System.out.println("Enter top rushee email");
                choice = scan.nextLine();
                removeTopRushees(choice, user, scan);
            }

        } else if(choice.equals("2")) {
            System.out.println("Choose an option");
            System.out.println("1. Message all rushees");
            System.out.println("2. Message top rushees");
            choice = scan.nextLine();
            message(choice, user, list, scan);

        } else {
            user.toString();
        }
        

    }

    public static void removeRushees(String email, User user, Scanner scan) {
        Frat frats = (Frat) user;
        ArrayList<String> list = frats.getRushees();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(email)) {
                list.remove(i);
                break;
            }
        }
    }
    public static void removeTopRushees(String email, User user, Scanner scan) {
        Frat frats = (Frat) user;
        ArrayList<String> list = frats.getTopRushees();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(email)) {
                list.remove(i);
                break;
            }
        }
    }
    

    public static void message(String choice, User user, ArrayList<User> list, Scanner scan) {
        System.out.println("Enter your message");
        String message = scan.nextLine();
        Frat frats = (Frat) user;
        if (choice.equals("1")) {
            for (String f : frats.getRushees()) {
                int position = findUser(list, f);
                list.get(position).addMessage(frats.getName() + "\n" + message);
            }

        } else {
            for (String f : frats.getRushees()) {
                int position = findUser(list, f);
                list.get(position).addMessage(frats.getName() + "\n" + message);
            }
        }
        
    }


    
}
