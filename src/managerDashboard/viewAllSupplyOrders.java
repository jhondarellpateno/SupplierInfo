/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerDashboard;

import config.config;

/**
 *
 * @author Administrator
 */
public class viewAllSupplyOrders {

    public static void viewAllSupplyOrders() {
        String query = "SELECT tbl_user.u_name, tbl_order.o_id, tbl_order.o_style, tbl_order.o_description, tbl_order.o_color, tbl_order.o_size, tbl_order.o_quantity, tbl_order.o_price, tbl_order.o_date, tbl_order.o_totalcost, tbl_order.o_status FROM tbl_order " +
                "JOIN tbl_user ON tbl_user.u_id = tbl_order.u_id ";
        
        config db = new config();

        String[] orderHeader = {"Supplier Name", "ID", "Style Code", "Description", "Color", "Size", "Quantity", "Wholsale Price", "Date of Delvery", "Total Cost", "Status"};
        String[] orderColumn = {"u_name","o_id", "o_style", "o_description", "o_color", "o_size", "o_quantity", "o_price", "o_date", "o_totalcost", "o_status"};

        db.viewRecords(query, orderHeader, orderColumn);

    }

}
