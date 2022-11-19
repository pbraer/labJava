/** Класс для работы с аккаунтами (реализует интерфейс AccountManager)
 @author p.braer
 */

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileAccountManager implements AccountManager {

    List<Account> accounts = new ArrayList<Account>();
    FailedLoginCounter counter = FailedLoginCounter.getInstance();
    FileService file = FileService.getInstance();


    /**
     * Метод проверяет по полю email, что данный аккаунт в базе
     * отсутствует, и создает новую запись, в противном случае
     * выбрасывает ошибку AccountAlreadyExistsException
     */
    public void register(Account account) throws IOException, AccountAlreadyExistsException {

        accounts = file.csvReader();
        int to_Change = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (Objects.equals(accounts.get(i).getEmail(), account.getEmail())) { // если найден аккаунт с таким же email
                to_Change = i;
            }
        }

        if (to_Change == -1) {
            accounts.add(account);
            file.csvWriter(accounts);
        } else {
            throw new AccountAlreadyExistsException("Аккаунт с заданным email уже зарегистрирован!");
        }

    }


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
    public Account login(String email, String password) throws IOException, AccountBlockedException, WrongCredentialsException {

        accounts = file.csvReader();
        int step = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (Objects.equals(accounts.get(i).getEmail(), email)) {
                step = i;

            }
        }

        if (step == -1) { // если аккаунта с данным email нет
            throw new WrongCredentialsException("Неверно введен email или пароль!");

        } else { // если есть аккаунт с данным email
            if (Objects.equals(accounts.get(step).getPassword(), password) && !accounts.get(step).getBlocked() &&
                    accounts.get(step).getCount() < 5) { // если верно введен пароль и данный аккаунт не заблокирован
                System.out.println("Вход выполнен!");
                return accounts.get(step);

            } else if (Objects.equals(accounts.get(step).getPassword(), password) && accounts.get(step).getCount() >= 5) { // если верно введен пароль,но данный аккаунт не заблокирован
                throw new AccountBlockedException("Ваш аккаунт заблокирован!");

            } else if (!Objects.equals(accounts.get(step).getPassword(), password)) { // неправильный пароль
                counter.plus(accounts.get(step));

                if (accounts.get(step).getCount() >= 5) {
                    accounts.get(step).setBlocked();
                }

                file.csvWriter(accounts);
                throw new WrongCredentialsException("Неверно введен email или пароль!");
            }
        }

        return accounts.get(step);
    }


    /**
     * Метод удаляет пользователя из базы, если логин и пароль
     * введены верно. В противном случае выбрасывает
     * ошибку WrongCredentialsException
     */
    public void removeAccount(String email, String password) throws IOException, WrongCredentialsException {
        accounts = file.csvReader();
        int step = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (Objects.equals(accounts.get(i).getEmail(), email)) {
                step = i;

            }
        }

        if (step == -1) {
            throw new WrongCredentialsException("Неверно введен email или пароль!");
        } else {

            if (Objects.equals(accounts.get(step).getPassword(), password)) {
                System.out.println("Пользователь удален.");
                accounts.remove(step);
                file.csvWriter(accounts);
            } else {
                throw new WrongCredentialsException("Неверно введен email или пароль!");
            }

        }
    }
}