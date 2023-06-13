package main;

import main.invoice.*;
import main.utility.*;
import main.exceptions.*;

import java.util.*;


public class SalesReportApp{

      public static void main(String[] args){

            int invoice_index=0;
            LinkedList<Invoice> invoicesList = new LinkedList<Invoice>();

            System.out.println("Enter the list of invoices: \n");
 
            do{
                 System.out.println("\nDetails of Invoice " + (++invoice_index) + ":");

                 LinkedList<ProductOrder> productOrders = new LinkedList<ProductOrder>();

                 do{
                     try{
                          productOrders.add(new ProductOrder(Validator_M.getString("\nEnter the product code: "),Validator.getInt("Enter the quantity: ",0)));
                     }         
                     catch(InvalidProductCodeException n){
                          System.out.println(n.getMessage());
                          continue;
                     }             
    
                 }while(!Validator.getString("\nAre you done? ").equals("done"));

                 try{
                      invoicesList.add(new Invoice(((Integer)(new Random().nextInt(100))).toString(),productOrders)); 
                 }
                 catch(NoSuchElementException n){
        
                       System.out.println("\nNo orders in this invoice!\n");
                 }
       
            }while(Validator.getString("\nAny more invoices left (y/n) ").equals("y"));
               
            SalesReport sr = new SalesReport();
            sr.createReport(invoicesList);

            System.out.println("\n\nSALES REPORT\n");
            sr.printReport();       
       }
}

