/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import static main.mainDashboard.mainDashboard;
import static main.updatePurchaseOrderStatus.updatePurchaseOrderStatus;
import static main.viewAllSupplyOrders.viewAllSupplyOrders;
import static main.viewPurchaseOrdersAndStatus.viewPurchaseOrdersAndStatus;

/**
 *
 * @author Administrator
 */
public class supplierDashboard {

    public static void supplierDashboard() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("---SUPPLIER DASHBOARD---");
            System.out.println("1. View Purchase Order and Status");
            System.out.println("2. Update Order Status");
            System.out.println("3. Log Out");
            System.out.println("Choose (1-3): ");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    viewPurchaseOrdersAndStatus();
                    break;
                    
                case 2: 
                    viewAllSupplyOrders();
                    updatePurchaseOrderStatus();
                    break;
                    
                case 3:
                    mainDashboard();
                    break;

                default:
                    System.out.println("ERROR!");

            }

        }
    }
}
