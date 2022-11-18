/** Класс аккаунтов
 @author p.braer
 */

public class Account {

    /**
     * username - имя пользователя
     * date_Birth - дата рождения
     * email - почта пользователя
     * password - пароль
     * blocked - параметр true / false, оказывающий, заблокирован ли пользователь (false по умолчанию)
     */

    private String username;
    private String date_Birth;
    private String email;
    private String password;
    private boolean blocked;

    public String getUsername() {
        return this.username;
    }

    public String getDate_Birth() {
        return this.date_Birth;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getBlocked() {
        return this.blocked;
    }

    public void setBlocked( boolean value) {
        this.blocked = value;
    }

    Account (String username, String date_Birth, String email, String password) {
        this.username = username;
        this.date_Birth = date_Birth;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }

}