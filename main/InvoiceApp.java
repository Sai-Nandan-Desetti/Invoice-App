package main;

import main.invoice.*;
import main.utility.*;
import main.exceptions.*;

import java.util.*;


public class InvoiceApp{
      
   public static void main(String args[]){

      LinkedList<ProductOrder> productOrders = new LinkedList<ProductOrder>();

      do{

          try{
             
             productOrders.add(new ProductOrder(Validator_M.getString("Enter the product code: "),Validator.getInt("Enter the quantity: ",0)));
          }         
          catch(InvalidProductCodeException n){

               System.out.println(n.getMessage());
               continue;
          }             
     
      }while(!Validator.getString("Are you done? ").equals("done"));          

 
      Random in_number = new Random();
      try{
            Collections.sort(productOrders);
            Invoice invoice = new Invoice(((Integer)(in_number.nextInt(100))).toString(),productOrders); 

            System.out.println("\n\n\nYou have ordered " + productOrders.size() + " item(s).\n");        
            System.out.println("Details of the invoice:\n" + invoice);
 
      }
      catch(NoSuchElementException n){

           System.out.println("You haven't ordered anything!\n");
      }
              
   }
       
}
