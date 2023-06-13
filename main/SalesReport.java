package main;

import main.invoice.*;

import java.text.*;
import java.util.*;


public class SalesReport{

//Data Members/Structures...

      private Map<String,ProductOrder> pCode_pOrder;



//Methods...
      
      public void createReport(LinkedList<Invoice> invoices){
            
            pCode_pOrder = new HashMap<String,ProductOrder>();

            Iterator<Invoice> in = invoices.listIterator(0);
              
            while(in.hasNext()){

                  LinkedList<ProductOrder> productOrders = in.next().getProductOrders();
                  Iterator<ProductOrder> p_o = productOrders.listIterator(0);
             
                  while(p_o.hasNext()){

                        ProductOrder pOrder = p_o.next();
                        String pCode = pOrder.getProduct().getCode();
                        
                        ProductOrder pOrderPrev = null;
                        try{
                             
                             pOrderPrev = pCode_pOrder.get((Object)pCode);

                             if(pOrderPrev!=null)
                                pOrder.updateOrder(pOrderPrev.getQuantity());

                            pCode_pOrder.put(pCode,pOrder);
                        }
                        catch(NullPointerException n){
                             
                             pCode_pOrder.put(pCode,pOrder);
                        }                        
                  }
            }
      }

      
      private String getFormattedTotal(double total){

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            return currency.format(total);
      } 

      public void printReport(){

            double grandTotal=0;

            Date today = new Date();
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
             
            System.out.println("Date: " + date.format(today) + "\n");

            System.out.println("Product code\tQnty sold\tPrice\t\tTotal\n");

            for(Map.Entry<String,ProductOrder> order : pCode_pOrder.entrySet()){

                ProductOrder pOrder = order.getValue();

                System.out.print(order.getKey() + " \t\t");
                System.out.print(pOrder.getQuantity() + "\t\t");
                System.out.print(pOrder.getProduct().getFormattedPrice() + "\t\t");
                System.out.print(pOrder.getFormattedTotal() + "\n");

                grandTotal+=pOrder.getTotal();
            }

            System.out.println("\nGrand Total: " + getFormattedTotal(grandTotal));
      }
}
                        
                 

      
