package main;

import main.invoice.*;

import java.io.*;
import java.util.*;
import java.net.*;


public class InvoiceApp1File{
      
       public static void main(String args[]){

              LinkedList<ProductOrder> productOrders = new LinkedList<ProductOrder>();              
       
              File product_database = new File("product_orders.txt");

//Read the file and create invoice.
              try{       
                   ReadMyFile.createListOfObjects(product_database,productOrders); 
        
                   Invoice invoice = new Invoice(((Integer)(new Random().nextInt(100))).toString(),productOrders);                     


                   //Store the invoice in a file and read it back.
                   try{                        
                         StoreMyObject.storeIntoFile("MyProductOrders",invoice);
                         StoreMyObject.readMyObjects("MyProductOrders",invoice);

                         System.out.println(invoice);
                   }
                   catch(InvalidClassException i){
              
                         System.out.println("\nSomething is wrong with a class used by serialization.");
                   }
                   catch(NotSerializableException n){

                         System.out.println("\nSome object that needs to be serialized has not implemented the java.io.Serializable interface.");
                   }
                   catch(ClassNotFoundException c){
 
                         System.out.println("\nClass of a serialized object cannot be found.");
                   }
                   catch(IOException i){
                         
                         System.out.println("\nError in opening file!");
                   }


                   //Send the invoice via DatagramSocket to 192.168.20.26, #9999.
                   try{
                         DatagramSocket ds = new DatagramSocket();
                                           
                         String name = "Desetti Sai Nandan";
                         byte[] name_data = name.getBytes();

                         ByteArrayOutputStream bos = new ByteArrayOutputStream();
                         ObjectOutputStream out = new ObjectOutputStream(bos);

                         out.writeObject(invoice);
                         out.flush();

                         byte[] invoice_data = bos.toByteArray();
                         byte[] data = new byte[name_data.length+invoice_data.length];
                    
                         bos.close();   

                         for(int i=0; i<name_data.length+invoice_data.length; i++)
                             if(i<name_data.length)
                                data[i] = name_data[i];
                             else
                                data[i] = invoice_data[i-name_data.length];

                  
                         DatagramPacket dp = new DatagramPacket(data,50);

                         dp.setAddress(InetAddress.getByName("192.168.20.26"));
                         dp.setPort(9999);                         

                         ds.send(dp);
                         ds.receive(dp);
                        
                         System.out.println(new String(dp.getData()));  

                         ds.close();                                                                       
                   }
                   catch(SocketException s){
 
                         System.out.println("Unable to open the socket.\n");
                   }
                   catch(UnknownHostException u){
                  
                         System.out.println("Incorrect IP Address!\n");
                   }
                   catch(IOException i){
                          
                         System.out.println("Unable to create array of objects.\n");
                   }                   
                                             
              }
              catch(FileNotFoundException f){

                    System.out.println("\nFile Not Found!");
              }
              catch(NoSuchElementException n){

                    System.out.println("\nEither the file is empty or you have not listed any product codes.");
              }     
                   

      }          
}
