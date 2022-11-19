/** Класс аккаунтов
 @author p.braer
 */


public class Account {

    /**
     * last_name - фамилия
     * first_Name - имя
     * middle_Name - отчество
     * date_Birth - дата рождения
     * email - почта пользователя
     * password - пароль
     * blocked - параметр true / false, оказывающий, заблокирован ли пользователь (false по умолчанию)
     * count - параметр для подсчета входов
     */

    private String last_Name;
    private String first_Name;
    private String middle_Name;
    private String date_Birth;
    private String email;
    private String password;
    private boolean blocked = true;
    private int count = -1;

    public Account() {}

    public Account(String last_Name, String first_Name, String middle_Name, String date_Birth, String email, String password) {
        this.last_Name = last_Name;
        this.first_Name = first_Name;
        this.middle_Name = middle_Name;
        this.date_Birth = date_Birth;
        this.email = email;
        this.password = password;
        this.blocked = false;
        this.count = 0;
    }

    @Override
    public String toString() {

        return last_Name + "," + first_Name + "," + middle_Name + "," + date_Birth +
                "," + email + "," + password + "," + blocked + "," + count + "\n";
    }

    public void setLast_Name(String last_Name) { this.last_Name = last_Name; }

    public void setFirst_Name(String first_Name) { this.first_Name = first_Name; }

    public void setMiddle_Name(String middle_Name) { this.middle_Name = middle_Name; }

    public void setDate_Birth(String date_Birth) { this.date_Birth = date_Birth; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Boolean getBlocked() { return blocked; }

    public void setBlocked() { this.blocked = !this.blocked; }

    public int getCount() { return count; }

    public void setCount(Integer count) { this.count = count; }

    public void countPlus() { this.count++; }

}