package main;

import main.invoice.*;
import main.exceptions.*;

import java.io.*;
import java.util.*;


public class ReadMyFile{

       public static void createListOfObjects(File file, LinkedList<ProductOrder> list)
              throws FileNotFoundException, NoSuchElementException
       {

              Scanner sc = new Scanner(file);
                   
              String details[] = new String[2];
              String line;
              int line_no = 1;

              sc.nextLine();                             
              while(sc.hasNextLine()){
                        
                   line = sc.nextLine();
                   line_no++;

                   if(line.length()>0){
                       
                      details = line.split("\\t\\t");             
                      try{                
                           list.add(new ProductOrder(details[0],Integer.parseInt(details[1])));
                      }
                      catch(ArrayIndexOutOfBoundsException a){
                            System.out.println("Incorrect format for entering product codes AND quantity at line number: " + line_no + "\n");
                      }
                      catch(InvalidProductCodeException i){
                            System.out.println(i.getMessage() + " at line number: " + line_no + "\n");
                      }
                      catch(InvalidQuantityException i){
                            System.out.println(i.getMessage() + " at line number: " + line_no);
                            System.out.println("You cannot have negative quantities!\n");
                      }                                
                       
                   }
              }
       }
}


