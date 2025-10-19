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
public class viewAllSupplyOrders {

    public static void viewAllSupplyOrders() {
        String query = "SELECT * FROM tbl_order";
        config db = new config();

        String[] orderHeader = {"ID", "Style Code", "Description", "Color", "Size", "Quantity", "Wholsale Price", "Date of Delvery", "Total Cost", "Status"};
        String[] orderColumn = {"o_id", "o_style", "o_description", "o_color", "o_size", "o_quantity", "o_price", "o_date", "o_totalcost", "o_status"};

        db.viewRecords(query, orderHeader, orderColumn);

    }

}
