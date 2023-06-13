package main.invoice;

import main.products.*;
import main.exceptions.*;
import main.products.db.*;

import java.io.*;
import java.util.Locale;
import java.text.NumberFormat;


public class ProductOrder implements Comparable<ProductOrder>, Serializable{

      double  total;
      private Product product;
      private int quantity;
      
      public static int orderObjectCount = 0;


      public ProductOrder(String pCode, int qty)
             throws InvalidProductCodeException, InvalidQuantityException
      {

           product = ProductDB.getProduct(pCode);
           if(product==null)
              throw new InvalidProductCodeException();

           if(qty<0)
              throw new InvalidQuantityException();

           quantity = qty;
           total=quantity*product.getPrice();

           orderObjectCount++;
      }

      public void updateOrder(int qty){

            quantity+=qty;
            total=quantity*product.getPrice();
      }

      public int getQuantity(){

           return quantity;
      }
 
      public Product getProduct(){

           return product;
      }

      public double getTotal(){

           return total;
      }

      public int compareTo(ProductOrder p){

           return ((Double)this.total).compareTo((Double)p.total);
      }

      public String getFormattedTotal(){

             NumberFormat currency = NumberFormat.getCurrencyInstance();
             return currency.format(total);
      } 

      public String toString(){

           return product + "Quantity:    " + quantity + "\n" + "Total amount: " + getFormattedTotal() + "\n";
      }
}
