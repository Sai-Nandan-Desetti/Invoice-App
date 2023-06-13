package main.products.db;

import main.products.*;
import main.utility.*;
import main.products.interfaces.*;

public class ProductDB
{
    public static Product getProduct(String productCode)
    {
        // In a more realistic application, this code would
        // get the data for the product from a file or database
        // For now, this code just uses if/else statements
        // to return the correct product data

        Product p = null;

        if (productCode.equalsIgnoreCase("java") ||
           productCode.equalsIgnoreCase("jsps") ||
           productCode.equalsIgnoreCase("mcb2"))
        {
            if (productCode.equalsIgnoreCase("java"))
            {
                Book b = new Book(productCode,"Murach's Beginning Java 2",49.50,"Andrea Steelman");
                p=b;
            }
            else if (productCode.equalsIgnoreCase("jsps"))
            {
                Book b = new Book(productCode,"Murach's Java Servlets and JSP",49.50,"Andrea Steelman");
                p=b;
            }
            else if (productCode.equalsIgnoreCase("mcb2"))
            {
                Book b = new Book(productCode,"Murach's Mainframe COBOL",59.50,"Mike Murach");
                p=b;
            }
        }
        else if (productCode.equalsIgnoreCase("txtpd"))
        {
            Software s = new Software("txtpd","TextPad",27.00,"4.7.3");
            p=s;
        }
        else if (productCode.equalsIgnoreCase("wrdpd"))
        {
		Software s = new Software("wrdpd","Word Pad",37.00,"6.3.3");
		p = s; // set Product object equal to the Software object
        }
        return p;
    }

    

    public static Book getBook(String productCode){
            
            if (productCode.equalsIgnoreCase("java"))
            {
                Book b = new Book(productCode,"Murach's Beginning Java 2",49.50,"Andrea Steelman");
                return b;
            }
            else if (productCode.equalsIgnoreCase("jsps"))
            {
                Book b = new Book(productCode,"Murach's Java Servlets and JSP",49.50,"Andrea Steelman");
                return b;
            }
            else if (productCode.equalsIgnoreCase("mcb2"))
            {
                Book b = new Book(productCode,"Murach's Mainframe COBOL",59.50,"Mike Murach");
                return b;
            }
           
            return null;
    }

    public static Software getSoftware(String productCode){
 
        if (productCode.equalsIgnoreCase("txtpd"))
        {
            Software s = new Software("txtpd","TextPad",27.00,"4.7.3");
            return s;
        }
        else if (productCode.equalsIgnoreCase("wrdpd"))
        {
            Software s = new Software("wrdpd","Word Pad",37.00,"6.3.3");
            return s;
        }

        return null;
    }

    /* 
       Pre:  a string, array of Products, no. of Products
       Post: true- if any Product's code matches the string
    */
    
    public static int duplicateProduct(String code, Product[] products, int noOfProducts){

          int i;

          for(i=0; i<noOfProducts && !code.equals(products[i].getCode()); i++);

          if(noOfProducts!=0 && i<noOfProducts)
             return i;

          return -1;
    }



    /* 
       Pre:  a Product
       Post: the type of the Product- "Book" or "Software"

       Description: the type is determined based on the Product's code
    */

    public static String productType(String productCode){

          if (productCode.equalsIgnoreCase("java") ||
              productCode.equalsIgnoreCase("jsps") ||
              productCode.equalsIgnoreCase("mcb2"))
      
              return "Book";

          else if(productCode.equalsIgnoreCase("txtpd") ||
                  productCode.equalsIgnoreCase("wrdpd"))
 
              return "Software";

          return null;
    }        




    /*
       Pre:  a Product
       Post: the modified Product
     
       Description: this method is basically used when the user has already created a Product 
                    and only wants to change a (few) detail(s) regarding the product
    */

    public static Book modifyProduct(Book b){

          int option;
          String code,desc,author,version,tag;
          String p_type;
          double price;

          System.out.println("What do you want to modify?");
          System.out.println("1.Code.");
          System.out.println("2.Description.");
          System.out.println("3.Price.");
          System.out.println("4.Author.");
          System.out.println("5.Tag.");

          option=Validator.getInt("\nEnter the option: ");

          System.out.print("\nEnter the ");


             switch(option){

              case 1: code=Validator.getString("code: ");
                      b.setCode(code);
                      break;

              case 2: desc=Validator.getString("description: ");
                      b.setDescription(desc);
                      break;

              case 3: price=Validator.getDouble("price: ");
                      b.setPrice(price);
                      break;
 
              case 4: author=Validator_M.getString("author: ");
                      b.setAuthor(author);
                      break;
                                  
              case 5: tag=Validator_M.getString("tag: ");
                      b.setTags(tag);
                      break;

              default: System.out.println("\nWrong Option!\n");
             }


         return b;
    }
    
    public static Software modifyProduct(Software s){

          int option;
          String code,desc,author,version,tag;
          String p_type;
          double price;

          System.out.println("What do you want to modify?");
          System.out.println("1.Code.");
          System.out.println("2.Description.");
          System.out.println("3.Price.");
          System.out.println("4.Version.");
          System.out.println("5.Tag.");

          option=Validator.getInt("\nEnter the option: ");

          System.out.print("\nEnter the ");


             switch(option){

              case 1: code=Validator.getString("code: ");
                      s.setCode(code);
                      break;

              case 2: desc=Validator.getString("description: ");
                      s.setDescription(desc);
                      break;

              case 3: price=Validator.getDouble("price: ");
                      s.setPrice(price);
                      break;
 
              case 4: version=Validator.getString("version: ");
                      s.setVersion(version);
                      break;  
            
              case 5: tag=Validator_M.getString("tag: ");
                      s.setTags(tag);
                      break;

              default: System.out.println("\nWrong Option!\n");
             }
        
          return s;
    }
}
