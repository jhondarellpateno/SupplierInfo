package main;

import config.config;
import java.util.Scanner;
import static adminDashboard.adminDashboard.adminDashboard;
import static managerDashboard.managerDashboard.managerDashboard;
import static supplierDashboard.supplierDashboard.supplierDashboard;

public class login {

    public static void logIn() {
        config db = new config();

        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- LOG IN ---");

        System.out.print("Enter email: ");
        String email = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();


            String qry = ("SELECT * FROM tbl_user WHERE u_email = ? AND u_pass = ?");
            java.util.List<java.util.Map<String, Object>> result = db.fetchRecords(qry, email, pass);

            if (result.isEmpty()) {
                System.out.println("INVALID CREDENTIALS!");
                
            } else {
                java.util.Map<String, Object> user = result.get(0);
                String id = user.get("u_id").toString();
                String stat = user.get("u_status").toString();
                String type = user.get("u_type").toString();

                if (stat.equals("Pending")) {
                    System.out.println("Account is pending, Please contact the admin to approve.");
                    

                } else {
                    System.out.println("LOGIN SUCCESS!");
                    if (type.equals("Admin")) {
                        adminDashboard();
                    } else if (type.equals("Manager")) {
                        managerDashboard();
                    } else if (type.equals("Supplier")) {
                        supplierDashboard(id);
                    }
                }

            }

        }

    
}
