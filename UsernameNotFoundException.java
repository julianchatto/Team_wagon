import java.util.InputMismatchException;

public class UsernameNotFoundException extends InputMismatchException {
    
    public UsernameNotFoundException() {
        super();
    }
    public UsernameNotFoundException(String message) {
        super(message);
    }
}
