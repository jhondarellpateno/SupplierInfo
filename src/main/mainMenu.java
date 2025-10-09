/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.util.Scanner;
import static main.login.logIn;
import static main.register.registerUser;

/**
 *
 * @author PC16
 */
public class mainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        config db = new config();
        db.connectDB();
        int choose;

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Log-in");
            System.out.println("2. Register");
            System.out.println("3. Exit Program");
            System.out.print("CHOOSE 1-3: ");
            choose = sc.nextInt();

            switch (choose) {

                case 1:
                    logIn();
                    break;

                case 2:
                    registerUser();
                    break;
                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Error! Please choose only 1, 2, or 3.");
            }

        }

    }

}
