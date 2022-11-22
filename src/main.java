/**
 * Класс для проверки написанного кода
 * <p>
 * создание аккаунтов А и В и повторное создание
 * аккаунта А
 * цепочка вызовов логина
 * А(н) -> B(н) -> A(н) -> A(н) -> A(н) -> A(н) blocked -> A(у) ex
 * B(н) -> B(у) -> B(н) -> B(н) -> B(н) -> B(н) -> B(у)
 * удаление А(у), В(н), В(у)
 *
 * @author p.braer
 */


import java.io.*;

public class main {
    public static void main(String[] args) throws IOException, AccountAlreadyExistsException, AccountBlockedException, WrongCredentialsException {
        FileAccountManager manage_Acc = new FileAccountManager();

        Account user1 = new Account("Браер", "Полина", "Сергеевна", "14.04.2002", "braer.a.s@gmail.com", "12345");
        Account user2 = new Account("Иванов", "Иван", "Иванович", "10.01.2001", "ivan001@gmail.com", "010101j");

        try {
            manage_Acc.register(user1);
            manage_Acc.register(user2);
            manage_Acc.register(user1);

        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());

        }

        try {
            for (int i = 0; i < 5; i++) {
                try {
                    manage_Acc.login("braer.a.s@gmail.com", "0000");

                } catch (WrongCredentialsException e) {
                    System.out.println(e.getMessage());
                }

            }
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        manage_Acc.login("braer.a.s@gmail.com", "12345");

        try {
            manage_Acc.login("ivan001@gmail.com", "0000");

        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }

        manage_Acc.login("ivan001@gmail.com", "010101j");

        for (int i = 0; i < 3; i++) {
            try {
                manage_Acc.login("ivan001@gmail.com", "0000");

            } catch (WrongCredentialsException e) {
                System.out.println(e.getMessage());
            }

        }

        manage_Acc.login("ivan001@gmail.com", "010101j");

        manage_Acc.removeAccount("braer.a.s@gmail.com", "12345");
        try {
            manage_Acc.removeAccount("ivan001@gmail.com", "0000");

        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
        manage_Acc.removeAccount("ivan001@gmail.com", "010101j");


    }

}
