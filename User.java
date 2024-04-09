package MockupTest;
public class User {
    private String username;
    private String password;
    private boolean locked;
    private int failedAttempts;
    private static final int MAX_FAILED_ATTEMPTS = 3;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.locked = false;
        this.failedAttempts = 0;
    }
    public boolean authenticate(String password) {
        if (!locked && this.password.equals(password)) {
            failedAttempts = 0;
            return true;
        } else {

            failedAttempts++;
            if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                lockUser();
            }
            return false;
        }
    }
    public boolean isLocked() {
        return locked;
    }
    public void resetPassword(String newPassword) {
        this.password = newPassword;
        if (locked) {
            unlockUser();
        }
    }
    public void lockUser() {
        locked = true;
    }
    public void unlockUser() {
        locked = false;
        failedAttempts = 0;
    }
}
