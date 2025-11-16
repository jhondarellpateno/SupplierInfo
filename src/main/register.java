package main;

import config.config;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class register {

    public static void registerUser() {

        Scanner sc = new Scanner(System.in);
        config db = new config();

        System.out.println("\n--- NEW USER REGISTRATION ---");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        String email = "";

        boolean emailExists = true;
        while (emailExists) {
            System.out.print("Enter your email: ");
            email = sc.nextLine();

            String qry = "SELECT * FROM tbl_user WHERE u_email = ?";
            java.util.List<java.util.Map<String, Object>> result = db.fetchRecords(qry, email);

            if (result.isEmpty()) {
                emailExists = false;
            } else {
                System.out.println("⚠️ Email already exists. Please enter another email.");
            }
        }

        System.out.print("Enter user type 1-Manager || 2-Supplier: ");
        int type = 0;

        while (type != 1 && type != 2) {
            if (sc.hasNextInt()) {
                type = sc.nextInt();
                if (type != 1 && type != 2) {
                    System.out.print("Invalid option! Please choose between 1 and 2 only: ");
                }
            } else {
                System.out.print("Invalid input! Please enter a number (1 or 2): ");
                sc.next();
            }
        }

        sc.nextLine();

        String tp = "";
        if (type == 1) {
            tp = "Manager";
        } else {
            tp = "Supplier";
        }

        String companyName = "";
        String address = "";
        String contact = "";

        if (tp.equals("Supplier")) {
            System.out.println("\n--- SUPPLIER DETAILS ---");
            System.out.print("Enter Company Name: ");
            companyName = sc.nextLine();
            System.out.print("Enter Company Address: ");
            address = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            contact = sc.nextLine();
        }

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        String hashedPass = db.hashPassword(pass);

        String sqlUser = "INSERT INTO tbl_user (u_name, u_email, u_type, u_pass, u_status) VALUES (?, ?, ?, ?, ?)";
        db.addRecord(sqlUser, name, email, tp, hashedPass, "Pending");

        if (tp.equals("Supplier")) {
            int userID = db.getLastID();

            String sqlSupplier = "INSERT INTO tbl_supplierinfo (u_id, supplier_name, supplier_contact, supplier_email, supplier_cname, supplier_address) VALUES (?, ?, ?, ?, ?, ?)";

            db.addRecord(sqlSupplier, userID, name, contact, email, companyName, address);

            System.out.println("\n Registration successful! Supplier account created and details saved.");
        } else {
            System.out.println("\n Registration successful! Manager account created.");
        }
        System.out.println("Your account status is Pending. Please wait for an Admin to approve.");

    }
}
