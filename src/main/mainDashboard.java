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
 * @author Administrator
 */
public class mainDashboard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        config db = new config();
        db.connectDB();
        int choose;
        boolean out = true;

        while (out) {
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
                    out = false;
                    break;

                default:
                    System.out.println("Error! Please choose only 1, 2, or 3.");
            }

        }

    }

}
