package managerDashboard;

import config.config;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import static managerDashboard.LProducts.ListOfProducts;
import static managerDashboard.viewAllSupplyOrders.viewAllSupplyOrders;

public class updateSupplyOrder {

    private static Map<String, Object> getOrderDetails(config db, int o_id) {
        String query = "SELECT * FROM tbl_order WHERE o_id = ?";
        List<Map<String, Object>> result = db.fetchRecords(query, o_id);
        
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public static void updateSupplyOrderInfo() {
        Scanner sc = new Scanner(System.in);
        config db = new config();
        Map<String, Object> currentOrder;
        int orderIdToUpdate = -1;

        System.out.println("\n===== UPDATE SUPPLY ORDER LINE ITEM =====");
       
        viewAllSupplyOrders();
        System.out.println("----------------------------------------");

        while (orderIdToUpdate <= 0) {
            System.out.print("Enter the ID (o_id) of the ORDER LINE ITEM to update: ");
            if (sc.hasNextInt()) {
                orderIdToUpdate = sc.nextInt();
                sc.nextLine(); 
                
                currentOrder = getOrderDetails(db, orderIdToUpdate);
                if (currentOrder == null) {
                    System.out.println("🚫 Error: Order ID " + orderIdToUpdate + " not found. Try again.");
                    orderIdToUpdate = -1; 
                } else if (orderIdToUpdate <= 0) {
                     System.out.println("Invalid ID. Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
            }
        }
        

        currentOrder = getOrderDetails(db, orderIdToUpdate);

        System.out.println("\n--- Updating Order ID: " + orderIdToUpdate + " (Supplier ID: " + currentOrder.get("u_id") + ") ---");
        System.out.println("NOTE: Press ENTER to keep the current value.");
        ListOfProducts();      
        String currentStyle = currentOrder.get("o_style").toString();
        System.out.printf("Current Style Code: %s\n", currentStyle);
        System.out.print("Enter New Style Code: ");
        String newStyleInput = sc.nextLine().trim();
        String newStyle = newStyleInput.isEmpty() ? currentStyle : newStyleInput;
        ListOfProducts();
        String currentDesc = currentOrder.get("o_description").toString();
        System.out.printf("Current Description: %s\n", currentDesc);
        System.out.print("Enter New Description: ");
        String newDescInput = sc.nextLine().trim();
        String newDesc = newDescInput.isEmpty() ? currentDesc : newDescInput;
        
        String currentColor = currentOrder.get("o_color").toString();
        System.out.printf("Current Color: %s\n", currentColor);
        System.out.print("Enter New Color: ");
        String newColorInput = sc.nextLine().trim();
        String newColor = newColorInput.isEmpty() ? currentColor : newColorInput;

        String currentSize = currentOrder.get("o_size").toString();
        System.out.printf("Current Size: %s\n", currentSize);
        System.out.print("Enter New Size: ");
        String newSizeInput = sc.nextLine().trim();
        String newSize = newSizeInput.isEmpty() ? currentSize : newSizeInput;
        
        int newQuantity = (int) currentOrder.get("o_quantity");
        double currentPrice = (double) currentOrder.get("o_price"); 
        
        while (true) {
            System.out.printf("Current Quantity: %d\n", newQuantity);
            System.out.print("Enter New Quantity (Enter a non-positive number to keep " + newQuantity + "): ");
            
            if (sc.hasNextInt()) {
                int inputQuan = sc.nextInt();
                sc.nextLine(); 
                
                if (inputQuan > 0) {
                    newQuantity = inputQuan;
                    break;
                } else if (inputQuan <= 0) {
                    System.out.println("Keeping old quantity: " + newQuantity);
                    break; 
                }
            } else {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    System.out.println("Keeping old quantity: " + newQuantity);
                    break; 
                }
                System.out.println("Invalid input. Please enter a number or press Enter to keep the current value.");
            }
        }
        
        double newPrice = currentPrice;
        while (true) {
            System.out.printf("Current Wholesale Price: ₱%.2f\n", newPrice);
            System.out.print("Enter New Wholesale Price (Enter a non-positive number to keep ₱" + String.format("%.2f", newPrice) + "): ");
            
            if (sc.hasNextDouble()) {
                double inputPrice = sc.nextDouble();
                sc.nextLine(); 
                
                if (inputPrice > 0.0) {
                    newPrice = inputPrice;
                    break;
                } else if (inputPrice <= 0.0) {
                    System.out.println("Keeping old price: ₱" + String.format("%.2f", newPrice));
                    break;
                }
            } else {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    System.out.println("Keeping old price: ₱" + String.format("%.2f", newPrice));
                    break; 
                }
                System.out.println("Invalid input. Please enter a number or press Enter to keep the current value.");
            }
        }


        double newTotalCost = newQuantity * newPrice;

        String sqlUpdate = "UPDATE tbl_order SET o_style = ?, o_description = ?, o_color = ?, o_size = ?, o_quantity = ?, o_price = ?, o_totalCost = ? WHERE o_id = ?";
        
        db.updateRecord(sqlUpdate, newStyle, newDesc, newColor, newSize, newQuantity, newPrice, newTotalCost,orderIdToUpdate);

        System.out.println("\n✅ Order Line Item (ID: " + orderIdToUpdate + ") successfully updated.");
        System.out.printf("   New Line Item Cost: ₱%.2f\n", newTotalCost);
        System.out.println("========================================\n");
    }
}