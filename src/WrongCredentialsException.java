/**
 * Ошибка WrongCredentialsException
 * Возникает при входе, если данные введены неверно
 *
 * @author p.braer
 */


public class WrongCredentialsException extends Exception{

    public WrongCredentialsException(String message) {
        super(message);
    }
}