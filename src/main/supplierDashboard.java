/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class supplierDashboard {

    public static void supplierDashboard() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("---SUPPLIER DASHBOARD---");
            System.out.println("1. View My Purchase Order And Status");
            System.out.println("2. View Performance Scorecard(Ratings)");
            System.out.println("3. Log Out");
            System.out.println("Choose (1-3): ");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:
                    break;

                default:
                    System.out.println("ERROR!");

            }

        }
    }
}
