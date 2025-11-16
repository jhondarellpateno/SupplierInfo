/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerDashboard;

import config.config;

/**
 *
 * @author PC16
 */
public class viewSupplier {

    public static void viewSupplierInfo() {
        config conf = new config();
        String supplierQuery = "SELECT * FROM tbl_supplierinfo";
        String[] supplierHeaders = {"ID", "Name", "Contact", "Email", "CompanyName", "Address"};
        String[] supplierColumns = {"u_id", "supplier_name", "supplier_contact", "supplier_email", "supplier_cname", "supplier_address"};

        conf.viewRecords(supplierQuery, supplierHeaders, supplierColumns);
    }
}
    