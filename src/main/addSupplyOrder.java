package main;

import config.config;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class addSupplyOrder {

    public static void addSupplyOrder() {
        Scanner sc = new Scanner(System.in);
        config db = new config();
        String respo;

        do {
            System.out.print("Enter ID of the Supplier: ");
            int s_id = sc.nextInt();
            System.out.print("Enter Style Code (e.g., VNECK, HOODIE): ");
            String styc = sc.next();
            System.out.print("Enter Item Description: ");
            String des = sc.next();
            System.out.print("Enter Color: ");
            String cl = sc.next();
            System.out.print("Enter Size (e.g, S, M, L, XL): ");
            String sz = sc.next();
            System.out.print("Enter Quantity To Order: ");
            int quan = sc.nextInt();
            System.out.print("Enter Wholesale Price Item: ");
            double wp = sc.nextDouble();

            LocalDate defaultDeliveryDate = LocalDate.now().plus(7, ChronoUnit.DAYS);
            String deliveryDate = defaultDeliveryDate.toString();
            System.out.println("Delivery Date: " + deliveryDate);

            

            System.out.println("\n---Processing Order---");
            double totalCost = quan * wp;
            System.out.print("Style Code: " + styc);
            System.out.print("\nItem Description: " + des);
            System.out.print("\nColor: " + cl);
            System.out.print("\nSize: " + sz);
            System.out.print("\nQuantity: " + quan);
            System.out.printf("\nWholesale Price: ₱%.2f", wp);
            System.out.printf("\nTotal Cost: ₱%.2f\n", totalCost);

            String sql = "INSERT INTO tbl_order (u_id, o_style, o_description, o_color, o_size, o_quantity, o_price, o_date, o_totalCost, o_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            db.addRecord(sql, s_id, styc, des, cl, sz, quan, wp, deliveryDate, totalCost, "Pending");
            
            System.out.println("Do you want to continue and add another order? (yes/no): ");
            respo = sc.next();

        } while (respo.equalsIgnoreCase("yes"));
        
        System.out.println("\nOrder Entry Finished. Returning to the previous menu.");
    }

}
