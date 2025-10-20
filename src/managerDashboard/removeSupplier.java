/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerDashboard;

import config.config;
import java.util.Scanner;

/**
 *
 * @author PC16
 */
public class removeSupplier {

    public static void removeSupplierInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ID to Delete: ");
        int d_id = sc.nextInt();

        config dbConfig = new config();
        String sqlDelete = "DELETE FROM tbl_supplierinfo WHERE supplier_id = ?";
        dbConfig.deleteRecord(sqlDelete, d_id);

    }

}
