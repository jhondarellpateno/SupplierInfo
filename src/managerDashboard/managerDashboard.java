package managerDashboard;

import java.util.Scanner;
import static managerDashboard.addSupplierInfo.addSupplierInfo;
import static managerDashboard.addSupplyOrder.addSupplyOrder;
import static managerDashboard.removeSupplier.removeSupplierInfo;
import static managerDashboard.updateSupplier.updateSupplierInfo;
import static managerDashboard.viewAllSupplyOrders.viewAllSupplyOrders;
import static managerDashboard.viewSupplier.viewSupplierInfo;

public class managerDashboard {

    public static void managerDashboard() {
        Scanner sc = new Scanner(System.in);
        boolean out = true;
        
        while (out) {

            System.out.println("1. Add supplier info.");
            System.out.println("2. View supplier info.");
            System.out.println("3. Update supplier info.");
            System.out.println("4. Remove supplier info.");
            System.out.println("5. Add Supply Order");
            System.out.println("6. View all supply orders");
            System.out.println("7. Log Out");

            System.out.print("Choose (1-7): ");
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
                    addSupplyOrder();
                    break;

                case 6:
                    viewAllSupplyOrders();

                    break;

                case 7:
                    out = false;
                    break;
                default:
                    System.out.println("ERROR!");

            }
        }
    }

}
