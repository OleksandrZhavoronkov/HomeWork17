package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//Создать генератор паролей, который будет генерировать случайные неповторяющиеся пароли по следующим правилам:
//Пароль состоит из 8 символов
//В пароле допускаются только латинские большие и маленькие буквы, цифры и символ подчеркивания
//Пароль обязательно должен содержать большие и маленькие буквы и цифры
public class PassGenerator {
    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the password Generator");
        System.out.println("How long your password should be? -> Enter digits");
        int input = Integer.parseInt(READER.readLine());
        //The firs list for English Letters
        ArrayList<String> letterList = new ArrayList<>();
        //Calling method to fill the list in
        fillLetter(letterList);
        //The second list for Numbers 0-9
        ArrayList<String> numberList = new ArrayList<>();
        //Calling method to fill the list in
        fillNumbers(numberList);
        //Thi third list just for _, wanted to have it more frequent than just put it in the second list
        ArrayList<String> lowDashList = new ArrayList<>();
        //Adding value to this list
        lowDashList.add("_");
        //Creating a list that contains password
        ArrayList<String> PasswordList = new ArrayList<>();
        //Function to fill the Passwordlist in
        for (int x = 0; x < input; x++) {
            int v = (int) (Math.random() * 3); // random digit from 0-2
            // if digit on previous step is 0 then adding random Letter from letters list
            if (v == 0) {
                int b = (int) (Math.random() * 52);
                PasswordList.add(String.valueOf(letterList.get(b)));
                //if digit on previous step is 1 then adding random Number from Numbers list
            } else if (v == 1) {
                int d = (int) (Math.random() * 10);
                PasswordList.add(String.valueOf(numberList.get(d)));
                //if digit on previous step is 2 then adding _ to the list
            } else {
                PasswordList.add(String.valueOf(lowDashList.get(0)));
            }
        }
        System.out.println("Your Password is:");
        //calling method to display Password
        displayPassword(PasswordList);
    }
    //Method to fill the list with English Alphabet A-a, Z-z
    public static void fillLetter (ArrayList<String> letterList) {
        for (char i = 'A'; i <= 'z'; i++) {
            String s = "";
            s = s + i;
            letterList.add(s);
            //In case some redundancy in letters
            if (i == 'Z') i = 'a' - 1;
        }
    }
    //Method to fill the list with Numbers 0-9
    public static void fillNumbers (ArrayList<String> numberList) {
        for (int j = 0; j < 10; j++) {
            String s = "";
            s = s + j;
            numberList.add(s);
        }
    }
    //Method to bring the password to the screen
    public static void displayPassword (ArrayList<String> PasswordList) {

        for (int d = 0; d < PasswordList.size(); d++) {
            String zz = PasswordList.get((d + PasswordList.size()) - PasswordList.size());
            System.out.print(zz);
        }
    }
}