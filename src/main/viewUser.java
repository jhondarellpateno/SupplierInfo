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
public class viewUser {

    public static void viewUser() {
        String query = "SELECT * FROM tbl_user";
        config db = new config();
        
        String[] userHeader = {"ID", "Name", "Email", "Type", "Status"};
        String[] userColumn = {"u_id", "u_name", "u_email", "u_type", "u_status"};
        
        db.viewRecords(query, userHeader, userColumn);
        
    }
    
}
