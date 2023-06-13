package main;

import main.invoice.*;

import java.io.*;
import java.util.*;


public class StoreMyObject{

       public static void storeIntoFile(String fileName, Invoice invoice)
              throws InvalidClassException, NotSerializableException, IOException
       {
           
              ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));    
               
              objectOut.writeObject(invoice);
    
              objectOut.close();
       }

       public static void readMyObjects(String fileName, Invoice invoice)
              throws InvalidClassException, ClassNotFoundException, IOException
       {
              ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));    
               
              invoice = (Invoice)objectIn.readObject();
    
              objectIn.close();           
       }
          
}
