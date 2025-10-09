/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.util.Scanner;
import static main.viewUser.viewUser;

/**
 *
 * @author Administrator
 */
public class adminDashboard {

    public static void adminDashboard() {

        Scanner sc = new Scanner(System.in);
        config db = new config();

        System.out.println("===WELCOME TO ADMIN DASHBOARD===");
        System.out.println("1. Approve Account");
        System.out.println("2. Exit");
        System.out.println("Choose 1 || 2: ");
        int approve = sc.nextInt();

        switch (approve) {
            case 1:
                viewUser();
                System.out.println("Enter ID to Approve: ");
                int ids = sc.nextInt();

                String sql = "UPDATE tbl_user SET u_status = ? WHERE u_id = ?";
                db.updateRecord(sql, "Approved", ids);
                break;
                
            case 2: 
                System.out.println("Exiting Program!");
                break;
            default:
                System.out.println("ErrOR!");
        }

    }
}
