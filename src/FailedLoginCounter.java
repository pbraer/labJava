/**
 * Класс-синглтон, который будет считать количество неудачных
 * попыток залогиниться. В случае, если пользователь 5 раз подряд
 * неправильно вводит пароль, его аккаунт блокируется (поле blocked по
 * умолчанию имеет значение true).
 *
 * @author p.braer
 */

public class FailedLoginCounter {

    /** приватное стат поле с сингл-объектом:
     */
    private static FailedLoginCounter instance;


    /** Сделать конструктор класса (конструктор по-умолчанию) приватным
     */
    private FailedLoginCounter() {
    }

    /** стат создающий метод
     * @return
     */
    public static FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    public void registration(Account account) {}

    public static void delete(Account account) {}

    public void wrong_login(Account account) {
        account.countPlus();
    }
}