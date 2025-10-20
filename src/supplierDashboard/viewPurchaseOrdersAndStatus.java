/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierDashboard;

import config.config;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class viewPurchaseOrdersAndStatus {

    public static void viewPurchaseOrdersAndStatus(String id) {

        config db = new config();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- VIEW SUPPLY ORDER ---");
       

        
        String orderQry = "SELECT * FROM tbl_order WHERE u_id = ?";

        List<Map<String, Object>> orderResult = db.fetchRecords(orderQry, id);

        if (orderResult.isEmpty()) {
            System.out.println("\n🚫 Error: Order ID  not found.");
            return;
        }

        for (Map<String, Object> order : orderResult) {
            
            System.out.println("-----ORDER DETAILS-----");
            System.out.println("Order ID           : " + order.get("o_id") + " ---");
            System.out.println("Supplier User ID   : " + order.get("u_id"));
            System.out.println("Delivery Date      : " + order.get("o_date"));
            System.out.println("Status             : " + order.get("o_status"));
            System.out.println("Total Cost         : " + order.get("o_totalcost"));
            System.out.println("----------------------------------------");

            System.out.println("Product Style      : " + order.get("o_style"));
            System.out.println("Product Color      : " + order.get("o_color"));
            System.out.println("Product Size       : " + order.get("o_size"));
            System.out.println("Quantity           : " + order.get("o_quantity"));
            System.out.println("Whole Sale         : " + order.get("o_price"));
            System.out.println("Description        : " + order.get("o_description"));
            System.out.println("----------------------------------------\n");

        }

    }
}
