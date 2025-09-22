/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.util.Scanner;
import static main.addSupplier.addSupplierInfo;
import static main.removeSupplier.removeSupplierInfo;
import static main.updateSupplier.updateSupplierInfo;
import static main.viewSupplier.viewSupplierInfo;

/**
 *
 * @author PC16
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
        
        System.out.println("1. Add supplier");
        System.out.println("2. View supplier info.");
        System.out.println("3. Update supplier info.");
        System.out.println("4. Remove supplier info.");
        System.out.println("5. Exit");
        
        System.out.println("Choose (1-5): ");
        int choice = sc.nextInt();
        
        switch(choice){
            
            case 1: 
                addSupplierInfo();
                
                break;
            case 2:
                viewSupplierInfo();
                
                break;
            
            case 3: 
                viewSupplierInfo();
                updateSupplierInfo();
                
                break;
            
            case 4: 
                viewSupplierInfo();
                removeSupplierInfo();
                
                break;
            
            case 5: 
                
                break;
            default:
                System.out.println("ERROR!");
            
            
        }
    }
    }
    
}
