/**
 * Класс-синглтон, который будет считать количество неудачных
 * попыток залогиниться. В случае, если пользователь 5 раз подряд
 * неправильно вводит пароль, его аккаунт блокируется (поле blocked по
 * умолчанию имеет значение true).
 *
 * @author p.braer
 */

import java.util.HashMap;
import java.util.Map;

public class FailedLoginCounter {
    private static volatile FailedLoginCounter instance;

    public static FailedLoginCounter getInstance() {
        FailedLoginCounter localInstance = instance;
        if (localInstance == null) {
            synchronized (FailedLoginCounter.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new FailedLoginCounter();
                }
            }
        }
        return localInstance;
    }

    /** Мапа для счета неудачных попыток по аккаунтам
     */
    private static Map<Account,Integer> block_count = new HashMap<>();

    /** Функция-счетчик для неудачных попыток входа
     * По истечению 5 попыток входа аккаунт блокируется
     */
    public static void login_Counter(Account account) throws MyExceptions {

        block_count.putIfAbsent(account, 0);
        block_count.put(account, block_count.get(account) + 1);
        if (block_count.get(account) >= 5) {
            account.setBlocked(true);
            throw new MyExceptions("AccountBlockedException: Закончились попытки ввода данных для входа в аккаунт. Ваш аккаунт заблокирован!");
        }
    }
}
