/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplierDashboard;

import java.util.Scanner;
import static supplierDashboard.updatePurchaseOrderStatus.updatePurchaseOrderStatus;
import static managerDashboard.viewAllSupplyOrders.viewAllSupplyOrders;
import static supplierDashboard.viewPurchaseOrdersAndStatus.viewPurchaseOrdersAndStatus;

/**
 *
 * @author Administrator
 */
public class supplierDashboard {

    public static void supplierDashboard(String id) {
        Scanner sc = new Scanner(System.in);
        boolean out = true;

        while (out) {

            System.out.println("---SUPPLIER DASHBOARD---");
            System.out.println("1. View Purchase Order and Status");
            System.out.println("2. Update Order Status");
            System.out.println("3. Log Out");
            System.out.println("Choose (1-3): ");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    viewPurchaseOrdersAndStatus(id);
                    break;
                    
                case 2: 
                    viewAllSupplyOrders();
                    updatePurchaseOrderStatus();
                    break;
                    
                case 3:
                    out = false;
                    break;

                default:
                    System.out.println("ERROR!");

            }

        }
    }
}
