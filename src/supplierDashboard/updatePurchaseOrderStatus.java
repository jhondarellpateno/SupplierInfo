package supplierDashboard;

import config.config;
import java.util.Scanner;

public class updatePurchaseOrderStatus {

    public static void updatePurchaseOrderStatus() {
        Scanner sc = new Scanner(System.in);
        config db = new config();

        System.out.println("\n--- UPDATE ORDER STATUS ---");

        System.out.print("Enter the Order ID (o_id) to update: ");
        int o_id = sc.nextInt();
        sc.nextLine();

        System.out.println("\n--- Set New Status ---");
        System.out.println("Available options: Shipped, Delivered.");
        System.out.println("Enter the new status: ");
        String newStatus = sc.nextLine().trim();

        String updateQry = "UPDATE tbl_order SET o_status = ? WHERE o_id = ?";

        db.updateRecord(updateQry, newStatus, o_id);

    }
}
