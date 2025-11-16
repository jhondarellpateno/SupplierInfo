/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerDashboard;

import config.config;

/**
 *
 * @author jhond
 */
public class LProducts {
    
    public static void ListOfProducts(){
        
        config conf = new config();
        String productQuery = "SELECT * FROM tbl_product";
        String[] productHeaders = {"ID", "Style", "Description"};
        String[] productColumns = {"p_id", "p_style", "p_description"};

        conf.viewRecords(productQuery, productHeaders, productColumns);
        
    }
    
}
