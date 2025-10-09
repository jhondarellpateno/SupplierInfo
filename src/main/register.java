/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class register {

    public static void registerUser() {

        Scanner sc = new Scanner(System.in);
        config db = new config();
        db.connectDB();

        System.out.println("\n--- NEW USER REGISTRATION ---");

        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter your email: ");
        String email = sc.next();

        String qry = "SELECT * FROM tbl_user WHERE u_email = ?";

        java.util.List<java.util.Map<String, Object>> result = db.fetchRecords(qry, email);

        if (result.isEmpty()) {
            System.out.println("");
        } else {
            System.out.print("Email already exist, Enter other email: ");
            email = sc.next();

        }
        System.out.print("Enter user type 1-Manager || 2-Supplier: ");
        int type = sc.nextInt();
        while (type > 2 || type < 1) {
            System.out.print("Invalid option! Please choose between 1 and 2 only: ");
            type = sc.nextInt();
        }
        String tp = "";
        if (type == 1) {
            tp = "Manager";

        } else {
            tp = "Supplier";
        }

        System.out.println("Enter password: ");
        String pass = sc.next();

        String sql = "INSERT INTO tbl_user (u_name, u_email, u_type, u_pass, u_status) VALUES (?, ?, ?, ?, ?)";
        db.addRecord(sql, name, email, tp, pass, "Pending");
    }

}
