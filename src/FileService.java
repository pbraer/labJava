/**
 * Класс-синглтон для работы с файлом
 *
 * @author p.braer
 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.valueOf;


public class FileService {
    private static FileService instance;

    private FileService() {} // конструктор класса

    public static FileService getInstance() { // общий стат метод
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }


    public List<Account> csv_Reader() throws IOException {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader to_read = new BufferedReader(new FileReader("data.csv"))) {

            String line = null;
            Scanner input = null;
            int param = 0;

            while ((line = to_read.readLine()) != null) {

                Account account = new Account();
                input = new Scanner(line);
                input.useDelimiter(",");

                while (input.hasNext()) {

                    String info = input.next();
                    if (param == 0) { account.setLast_Name(info); }
                    else if (param == 1) { account.setFirst_Name(info); }
                    else if (param == 2) { account.setMiddle_Name(info); }
                    else if (param == 3) { account.setDate_Birth(info); }
                    else if (param == 4) { account.setEmail(info); }
                    else if (param == 5) { account.setPassword(info); }
                    else if (param == 6) { account.setBlocked(); }
                    else if (param == 7) { account.setCount(valueOf(info)); }
                    else { System.out.println("Данные некорректны!"); }
                    param++;
                }

                accounts.add(account);
                param = 0;
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        //закрываем наш ридер
        return accounts;
    }

    public void csvWriter(List<Account> accounts) throws IOException {

        String path = "data.csv";

        BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv"));

        for (Account account : accounts) {
            writer.write(String.valueOf(account));
        }
        writer.close();
    }


}