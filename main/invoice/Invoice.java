package main.invoice;

import main.invoice.*;

import java.text.NumberFormat;
import java.util.*;
import java.io.*;

public class Invoice implements Serializable{

      private String invoiceNumber;
      private Date date;
      private LinkedList<ProductOrder> productOrders;
      private double total;


      public Invoice(String in_no, LinkedList<ProductOrder> p_o) throws NoSuchElementException{

             invoiceNumber = in_no;
             date = new Date();
             productOrders = p_o;
             
             productOrders.element();

             Iterator<ProductOrder> head = productOrders.listIterator(0);
             while(head.hasNext())
                  total+=head.next().total;
             
      }

      public LinkedList<ProductOrder> getProductOrders(){

             return productOrders;
      }

      public String printProductOrders(){

             String orders="\nProduct Orders:\n\n";
             int i=0;

             Iterator<ProductOrder> head = productOrders.listIterator(0);
             while(head.hasNext())
                  orders+="Product " + (++i) +":\n" + head.next().toString() + "\n";

             return orders;
      }

      public String getFormattedTotal(){

             NumberFormat currency = NumberFormat.getCurrencyInstance();
             return currency.format(total);
      }

      public String toString(){

            return "Invoice No." + invoiceNumber + "\n" + 
                   "Date & Time of purchase: " + date + "\n" + 
                   this.printProductOrders() + "\n" +
                   "Total cost of purchase: " + getFormattedTotal();
      }
}
