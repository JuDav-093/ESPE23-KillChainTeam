package ec.edu.espe.evsustore.controller;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.evsustore.utils.PasswordUtils;
import ec.edu.espe.evsustore.utils.SessionManager;
import ec.edu.espe.evsustore.utils.EmailUtils;
import javax.mail.MessagingException;


/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class SessionController {
    DatabaseController database;
    MongoCollection collection;

    private static SessionController instance;

    private SessionController() {
        this.database = DatabaseController.getInstance();
        this.collection = this.database.changeCollection("Users");
    }

    public synchronized static SessionController getInstance() {
        if (instance == null) {
            instance = new SessionController();
        }

        return instance;
    }

    PasswordUtils passwordUtils = new PasswordUtils();
    EmailUtils emailUtils=new EmailUtils();

    public boolean checkCredentials(String username, String password) {
    if (passwordUtils.checkCredentials(username, password, collection)) {
        if (SessionManager.startSession(username, collection)) {
            return true;
        }
    }
    return false;
}

    public void migratePasswordsToBCrypt() {
        passwordUtils.migratePasswordsToBCrypt(collection);
    }

    public boolean createUser(String name, String lastName, String username, String password) {
        return passwordUtils.createUser(name, lastName, username, password, collection);
    }

    public boolean changePassword(String confirmPassword) {
        String currentUsername = SessionManager.getCurrentUser();
        if (currentUsername != null && SessionManager.sessionActive()) {
            return passwordUtils.changePassword(confirmPassword, collection);
        }
        return false;
    }

    public void setNewPassword(String newPassword) {
        passwordUtils.setNewPassword(newPassword);
    }

    public String getPasswordByUsername(String username) {
        return passwordUtils.getPasswordByUsername(username, collection);
    }

    public String generateTemporaryPassword() {
        return passwordUtils.generateTemporaryPassword();
    }

    public String generateRandomPassword() {
        return passwordUtils.generateRandomPassword();
    }

    public boolean updatePassword(String username, String newPassword, String temporaryPassword) {
        return passwordUtils.updatePassword(username, newPassword, temporaryPassword, collection);
    }
    
    public void sendRecoveryEmail(String recipient, String username, String temporaryPassword) throws MessagingException {
        emailUtils.sendRecoveryEmail(recipient, username, temporaryPassword);
        
    }
    

}