/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;

/**
 *
 * @author Administrator
 */
public class userSupplier {
    public static void viewSupplier() {
        String query = "SELECT * FROM tbl_supplier";
        config db = new config();
        
        String[] userHeader = {"ID"};
        String[] userColumn = {"u_id"};
        
        db.viewRecords(query, userHeader, userColumn);
        
    }
    
}
