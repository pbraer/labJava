/**
 * Ошибка AccountBlockedException
 * Возникает при входе, если данные верны, но пользователь заблокирован
 *
 * @author p.braer
 */


public class AccountBlockedException extends Exception{

    public AccountBlockedException(String message) {
        super(message);
    }
}