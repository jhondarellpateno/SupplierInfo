/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.util.Scanner;
import static main.userSupplier.viewSupplier;

/**
 *
 * @author PC16
 */
public class addSupplierInfo {

    public static void addSupplierInfo() {

        Scanner sc = new Scanner(System.in);
        config db = new config();

        viewSupplier();
        System.out.println("Enter Supplier ID: ");
        int s_id = sc.nextInt();
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter contact number: ");
        String contact = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("Enter Company Name: ");
        String cname = sc.next();
        System.out.println("Enter Address: ");
        String address = sc.next();
        System.out.println("Enter Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_supplierinfo (u_id, supplier_name, supplier_contact, supplier_email, supplier_cname, supplier_address, supplier_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        db.addRecord(sql, s_id, name, contact, email, cname, address, status);
        

    }

}
