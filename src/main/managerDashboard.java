package main;

import java.util.Scanner;
import static main.addNewSupplyOrder.addNewSupplyOrder;
import static main.addSupplier.addSupplierInfo;
import static main.removeSupplier.removeSupplierInfo;
import static main.updateSupplier.updateSupplierInfo;
import static main.viewAllSupplyOrders.viewAllSupplyOrders;
import static main.viewSupplier.viewSupplierInfo;

public class managerDashboard {

    public static void managerDashboard() {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("1. Add supplier");
            System.out.println("2. View supplier info.");
            System.out.println("3. Update supplier info.");
            System.out.println("4. Remove supplier info.");
            System.out.println("5. Add a new supply order");
            System.out.println("6. View all supply orders");
            System.out.println("7. Exit");

            System.out.print("Choose (1-5): ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addSupplierInfo();

                    break;
                case 2:
                    viewSupplierInfo();

                    break;

                case 3:
                    viewSupplierInfo();
                    updateSupplierInfo();

                    break;

                case 4:
                    viewSupplierInfo();
                    removeSupplierInfo();

                    break;

                case 5:
                    addNewSupplyOrder();

                    break;

                case 6:
                    viewAllSupplyOrders();

                    break;

                case 7:

                    break;
                default:
                    System.out.println("ERROR!");

            }
        }
    }

}
