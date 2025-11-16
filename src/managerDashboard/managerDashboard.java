package managerDashboard;

import java.util.Scanner;
import static managerDashboard.LProducts.ListOfProducts;
import static managerDashboard.addSupplyOrder.addSupplyOrder;
import static managerDashboard.removeSupplier.removeSupplierInfo;
import static managerDashboard.updateSupplyOrder.updateSupplyOrderInfo;
import static managerDashboard.viewAllSupplyOrders.viewAllSupplyOrders;
import static managerDashboard.viewSupplier.viewSupplierInfo;

public class managerDashboard {

    public static void managerDashboard() {
        Scanner sc = new Scanner(System.in);
        boolean out = true;
        
        while (out) {

            System.out.println("1. Add Supply Order");
            System.out.println("2. View all supply orders");
            System.out.println("3. Update supply order");
            System.out.println("4. View Supplier info.");
            System.out.println("5. Remove supplier");
            System.out.println("6. Log Out");

            System.out.print("Choose (1-6): ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    ListOfProducts();
                    addSupplyOrder();
     
                    break;
                case 2:
                    viewAllSupplyOrders();

                    break;

                case 3:
                    updateSupplyOrderInfo();

                    break;

                case 4:
                    viewSupplierInfo();
                    break;
                    
                case 5:
                    viewSupplierInfo();
                    removeSupplierInfo();
                    break;

                case 6:
                    out = false;
                    break;
                default:
                    System.out.println("ERROR!");

            }
        }
    }

}
