/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.util.Scanner;

/**
 *
 * @author PC16
 */
public class updateSupplier {

    public static void updateSupplierInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ID to Update: ");
        int id = sc.nextInt();
        System.out.println("Enter new name: ");
        String nn = sc.next();
        System.out.println("Enter new contact: ");
        String nc = sc.next();
        System.out.println("Enter new email: ");
        String ne = sc.next();
        System.out.println("Enter new address: ");
        String na = sc.next();

        config dbConfig = new config();
        String sqlUpdate = "UPDATE tbl_supplierinfo SET supplier_name = ?, supplier_contact = ?, supplier_email = ?, supplier_address = ? WHERE supplier_id = ?";
        dbConfig.updateRecord(sqlUpdate, nn, nc, ne, na, id);

    }

}
