package main;

import java.util.Arrays;
import main.products.*;
import main.products.db.*;
import main.products.interfaces.*;
import main.utility.*;

public class ProductApp{

      /** 
          Written on: 28.11.2019
          
          Description: A driver class to implement the methods described in Product class

       */

       public static void main(String[] args){

             String choice;
             String code,tag;

             Product products[]=new Product[10];
             Product p=null;
             Book b=null;
             Software s=null;

             int i=0,product_no,option;

             do{
  
                 option=2; 
                 choice="y";
               
                 code=Validator.getString("\nEnter the code: ");
  
                 product_no=ProductDB.duplicateProduct(code,products,i);

                 if(product_no!=-1){

                    System.out.println("\nA product with this code already exists!");
                    System.out.println("\nWhat do you want to do?\n");
                    System.out.println("1.Modify a detail regarding the product.");
                    System.out.println("2.Create another product with the same code.");

                    option=Validator.getInt("\nEnter the option: ",0,3);

                    if(option==1){
                       do{
                           if(ProductDB.productType(code).equals("Book")){
                              b=ProductDB.modifyProduct(b);
                              products[product_no]=b;
                           }
                           else if(ProductDB.productType(code).equals("Software")){
                               s=ProductDB.modifyProduct(s);
                               products[product_no]=s;
                           }
                           choice=Validator.getString("Do you want to modify any other detail?(y/n)");

                       }while(choice.equals("y"));

                    }
                       
                 }
                 
                 if(option==2){

                      if(ProductDB.productType(code)==null)
                          System.out.println("No product matches this product code");

                      else{
                            if(ProductDB.productType(code).equals("Book")){
                               b=ProductDB.getBook(code);
                               p=b;
                            }
                            else if(ProductDB.productType(code).equals("Software")){
                                s=ProductDB.getSoftware(code);
                                p=s;
                            }
                        
                            products[i]=p;
                            System.out.println("Details of the product:\n"+p);

                            choice=Validator.getString("Do you want to set a tag?(y/n)");
                            if(choice.equals("y")){
                               tag=Validator_M.getString("\nEnter the tag: ");
                               products[i].setTags(tag);
                            }
                     
                            i++;
                  
                            System.out.println("\nThe no.of objects created: "+Product.getCount());
                      }
                 
                 }

                 choice=Validator.getString("\nDo you want to continue?(y/n)");

             }while(i<10 && choice.equals("y"));
             
             if(i==0)           
                System.out.println("\nYou've not created any valid product!");

             else{

                   System.out.println("\nThe "+i+" product(s) created by you is(are) listed below in a sorted order:\n");
                   Arrays.sort(products,0,i);
                    
                   for(int a=0;a<i;a++){
                       System.out.println(a+1+")");
                       System.out.println(products[a]);
                   }
             }
        }     
}
