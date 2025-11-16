package managerDashboard;

import config.config;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import static managerDashboard.viewSupplier.viewSupplierInfo; 

public class addSupplyOrder {

    private static Map<String, Object> selectProductFromCatalog(config db, Scanner sc) {
        String query = "SELECT p_style, p_description FROM tbl_product GROUP BY p_style, p_description";
        List<Map<String, Object>> products = db.fetchRecords(query);

        if (products.isEmpty()) {
            System.out.println("No products found in the catalog. You must enter details manually.");
            return null;
        }

        System.out.println("\n--- Product Catalog Selection ---");
        System.out.println("ID | Style Code | Description");
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> product = products.get(i);
            System.out.printf("%2d | %-10s | %s\n", 
                i + 1, 
                product.get("p_style"), 
                product.get("p_description")
            );
        }
        System.out.println("----------------------------------------");

        int choice = -1;
        while (choice < 1 || choice > products.size()) {
            System.out.print("Choose a product ID (1-" + products.size() + ") or enter 0 to input manually: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice == 0) {
                    sc.nextLine(); 
                    return null;
                }
            } else {
                sc.next(); 
            }
        }
        
        sc.nextLine(); 
        
        Map<String, Object> selectedProduct = products.get(choice - 1);

        System.out.println("✅ Selected Style: " + selectedProduct.get("p_style"));
        System.out.println("✅ Selected Description: " + selectedProduct.get("p_description"));
        
        return selectedProduct;
    }

    public static void addSupplyOrder() {
        Scanner sc = new Scanner(System.in);
        config db = new config();
        String continueAddingProducts; 
        double totalOrderCost = 0.0;
        int lineItemCount = 0;

        System.out.println("\n===== START NEW SUPPLY ORDER =====");
        
        viewSupplierInfo(); 
        System.out.print("Enter ID of the Supplier (u_id) for this order: ");
        int s_id = sc.nextInt();
        
        LocalDate defaultDeliveryDate = LocalDate.now().plus(7, ChronoUnit.DAYS);
        String deliveryDate = defaultDeliveryDate.toString();
        System.out.println("The expected Delivery Date for all items in this order is: " + deliveryDate);

        sc.nextLine();

        do {
            System.out.println("\n----------------------------------");
            System.out.println("--- ADD NEW PRODUCT (Style/Description) ---");
            
            String styc = "";
            String des = "";
            
            Map<String, Object> selectedProduct = selectProductFromCatalog(db, sc);

            if (selectedProduct != null) {
                styc = selectedProduct.get("p_style").toString();
                des = selectedProduct.get("p_description").toString();
            } else {
                // Manual input
                System.out.print("Enter Style Code (e.g., VNECK, HOODIE): ");
                styc = sc.nextLine();
                System.out.print("Enter Item Description: ");
                des = sc.nextLine();
            }

            String continueAddingSizes;

            do {
                System.out.println("\n--- Entering Line Item #" + (lineItemCount + 1) + " for Product: " + styc + "/" + des + " ---");
                
                System.out.print("Enter Color: ");
                String cl = sc.nextLine(); 

                System.out.print("Enter Size (e.g, S, M, L, XL): ");
                String sz = sc.nextLine();
                
                int quan = 0;
                while(quan <= 0) {
                    System.out.print("Enter Quantity To Order (must be > 0): ");
                    if (sc.hasNextInt()) {
                        quan = sc.nextInt();
                        if (quan <= 0) {
                             System.out.println("Quantity must be greater than zero.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next(); 
                    }
                }

                double wp = 0.0;
                while(wp <= 0.0) {
                    System.out.print("Enter Wholesale Price Item (must be > 0): ");
                    if (sc.hasNextDouble()) {
                        wp = sc.nextDouble();
                        if (wp <= 0.0) {
                             System.out.println("Wholesale price must be greater than zero.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next(); 
                    }
                }
                
                sc.nextLine(); 

                double lineItemCost = quan * wp; 
                totalOrderCost += lineItemCost;
                lineItemCount++;
                
                String insertSql = "INSERT INTO tbl_order (u_id, o_style, o_description, o_color, o_size, o_quantity, o_price, o_date, o_totalCost, o_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                db.addRecord(insertSql, s_id, styc, des, cl, sz, quan, wp, deliveryDate, lineItemCost, "Pending");
                
                System.out.println("\n✅ Line Item added to order.");
                System.out.printf("   Line Item Cost: ₱%.2f\n", lineItemCost);
                System.out.printf("   Current Order Grand Total: ₱%.2f\n", totalOrderCost);
                
                System.out.println("\nDo you want to add a DIFFERENT SIZE/COLOR combination for THIS PRODUCT (" + styc + ")? (yes/no): ");
                continueAddingSizes = sc.nextLine().trim();
                
            } while (continueAddingSizes.equalsIgnoreCase("yes"));

            System.out.println("\n----------------------------------");
            System.out.println("Do you want to add a NEW, DIFFERENT PRODUCT (Style/Description)? (yes/no): ");
            continueAddingProducts = sc.nextLine().trim();

        } while (continueAddingProducts.equalsIgnoreCase("yes"));
        
        System.out.println("\n==================================");
        System.out.println("🛒 Purchase Order Complete!");
        System.out.println("==================================");
        System.out.println("   Supplier ID: " + s_id);
        System.out.println("   Total Line Items Added: " + lineItemCount);
        System.out.printf("   FINAL GRAND TOTAL: ₱%.2f\n", totalOrderCost);
        System.out.println("==================================");
        System.out.println("Returning to the previous menu.");
    }
}