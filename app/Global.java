import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;

/**
 * Provide initialization code for the digits application.
 * @author Philip Johnson
 */
public class Global extends GlobalSettings {

  /**
   * Initialize the system with some sample contacts.
   * @param app The application.
   */
  public void onStart(Application app) {
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    
    if(!UserInfoDB.adminDefined()){
      UserInfoDB.defineAdmin("Administrator", adminEmail, adminPassword);
      UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    }
  }
}
