/**
 * Ошибка AccountAlreadyExistsException
 * Возникает при регистрации, если пользователь с заданным email уже существует
 *
 * @author p.braer
 */


public class AccountAlreadyExistsException extends Exception{

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}