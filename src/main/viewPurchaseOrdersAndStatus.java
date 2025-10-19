/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class viewPurchaseOrdersAndStatus {
    public static void viewPurchaseOrdersAndStatus(){
        
        config db = new config();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- VIEW SUPPLY ORDER ---");
        System.out.print("Enter the Order ID to view: ");
        
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a numerical ID.");
            sc.next(); 
            return;
        }
        int orderId = sc.nextInt();
        sc.nextLine(); 

        String orderQry = "SELECT * FROM tbl_order WHERE o_id = ?";
        List<Map<String, Object>> orderResult = db.fetchRecords(orderQry, orderId);

        if (orderResult.isEmpty()) {
            System.out.println("\n🚫 Error: Order ID " + orderId + " not found.");
            return;
        }

        Map<String, Object> order = orderResult.get(0);
        
        System.out.println("\n--- Order Item Details: " + order.get("o_id") + " ---");
        System.out.println("Supplier User ID: " + order.get("u_id"));
        System.out.println("Delivery Date: " + order.get("o_date"));
        System.out.println("Status: " + order.get("o_status"));
        System.out.println("Total Cost: " + order.get("o_totalcost"));
        System.out.println("----------------------------------------");
        
        System.out.println("Product Style: " + order.get("o_style"));
        System.out.println("Product Color: " + order.get("o_color"));
        System.out.println("Product Size: " + order.get("o_size"));
        System.out.println("Quantity: " + order.get("o_quantity"));
        System.out.println("Whole Sale: " + order.get("o_price"));
        System.out.println("Description: " + order.get("o_description"));
        System.out.println("----------------------------------------\n");
    }
    }
    

