package by.halaunia.main;

import by.halaunia.service.HelloUser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Приветствовать любого пользователя при вводе его имени через командную строку
        while (true) {
            HelloUser.welcomeUser();
        }

    }
}
