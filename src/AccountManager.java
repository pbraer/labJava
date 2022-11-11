/** Интерфейс управления аккаунтами, для базы используется
 * текстовый файл в формате CSV */

public interface AccountManager {

    /**
            * Метод проверяет по полю email, что данный аккаунт в базе
    * отсутствует, и создает новую запись, в противном случае
    * выбрасывает ошибку AccountAlreadyExistsException
    */
    void register(Account account);


    /**
     * Метод возвращает Account, если для email+пароль есть
     * подходящая запись в базе и аккаунт не заблокирован.
     * Если неверно введены email и/или пароль - выбрасывается
     * исключение WrongCredentialsException.
     * Если email и пароль верны, но аккаунт заблокирован -
     * выбрасывается исключение AccountBlockedException.
     * Если для конкретного пользователя больше 5 неудачных
     * попыток авторизоваться, то аккаунт блокируется.
     */


    Account login(String email, String password);
    /**
     * Метод удаляет пользователя из базы, если логин и пароль
     * введены верно. В противном случае выбрасывает
     * ошибку WrongCredentialsException
     */


    void removeAccount(String email, String password);
}